/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseStatus;
import communication.Sender;
import controller.Controller;
import domain.Administrator;
import domain.Author;
import domain.Administrator;
import domain.Member;
import domain.Book;
import domain.MemberType;
import domain.Rental;
import domain.RentalItem;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;
import server.ServerController;

/**
 *
 * @author Jelena
 */
public class ProcessClientRequests extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    Administrator administrator;
    List<Administrator> loggedInAll;

    //Server server;
    public ProcessClientRequests(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
        loggedInAll = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Response response = new Response(null, null, ResponseStatus.Success);
                Request request = (Request) receiver.receive();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            administrator = (Administrator) request.getArgument();
                            if (ServerController.getInstance().isItActive(administrator) == false) {
                                if (ServerController.getInstance().isTheUsernameCorrect(administrator)
                                        && ServerController.getInstance().isThePasswordCorrect(administrator)) {
                                    Administrator activeAdministrator = ServerController.getInstance().returnSpecificAdministrator(administrator);
                                    ServerController.getInstance().addActiveAdministrator(activeAdministrator);
                                    Controller.getInstance().login(administrator);
                                    response.setException("Login successful, welcome " + activeAdministrator.getFirstname() + "!");
                                    response.setResponseStatus(ResponseStatus.Success);
                                    response.setResult(activeAdministrator);
                                } else {
                                    response.setResponseStatus(ResponseStatus.Error);
                                    response.setException("Incorrect username or password!");
                                }
                            } else {
                                response.setException("The administrator is already logged in!");
                                response.setResponseStatus(ResponseStatus.Error);
                            }

                            break;
                        case LOGOFF:
                            administrator = (Administrator) request.getArgument();

                            if (ServerController.getInstance().removeSpecificAdministrator(administrator)) {
                                response.setException("You have successfully logged out!");
                                response.setResponseStatus(ResponseStatus.Success);
                            } else {
                                response.setException("Unable to log out administrator!");
                                response.setResponseStatus(ResponseStatus.Error);
                            }
                            break;

                        case GET_ALL_MEMBER_TYPE:
                            response.setResult(Controller.getInstance().getAllMemberType());
                            break;
                        case GET_ALL_AUTHOR:
                            response.setResult(Controller.getInstance().getAllAuthors());
                            break;
                        case ADD_AUTHOR:
                            response.setResult(Controller.getInstance().addAuthor((Author) request.getArgument()));
                            break;
                        case DELETE_AUTHOR:
                            Controller.getInstance().deleteAuthor((Author) request.getArgument());
                            break;
                        case EDIT_AUTHOR:
                            Controller.getInstance().updateAuthor((Author) request.getArgument());
                            break;
                        case GET_ALL_BOOKS:
                            response.setResult(Controller.getInstance().getAllBooks());
                            break;
                        case ADD_BOOK:
                            response.setResult(Controller.getInstance().addBook((Book) request.getArgument()));
                            break;
                        case DELETE_BOOK:
                            Controller.getInstance().deleteBook((Book) request.getArgument());
                            break;
                        case EDIT_BOOK:
                            Controller.getInstance().updateBook((Book) request.getArgument());
                            break;
                        case GET_ALL_MEMBERS:
                            response.setResult(Controller.getInstance().getAllMembers((MemberType) request.getArgument()));
                            break;
                        case ADD_MEMBER:
                            response.setResult(Controller.getInstance().addMember((Member) request.getArgument()));
                            break;
                        case DELETE_MEMBER:
                            Controller.getInstance().deleteMember((Member) request.getArgument());
                            break;
                        case EDIT_MEMBER:
                            Controller.getInstance().updateMember((Member) request.getArgument());
                            break;
                        case GET_ALL_RENTALS:
                            response.setResult(Controller.getInstance().getAllRentals());
                            break;
                        case GET_ALL_RENTALS_BY_MEMBER:
                            response.setResult(Controller.getInstance().getAllRentalsByMember((Member) request.getArgument()));
                            break;
                        case EDIT_RENTAL:
                            Controller.getInstance().updateRental((Rental) request.getArgument());
                            break;
                        case ADD_RENTAL:
                            response.setResult(Controller.getInstance().addRental((Rental) request.getArgument()));
                            break;

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //response.setException(ex);
                    response.setResponseStatus(ResponseStatus.Error);
                }
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public Socket getSocket() {
        return socket;
    }

}
