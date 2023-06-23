/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Administrator;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import domain.Member;
import domain.MemberType;
import domain.Rental;
import domain.RentalItem;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class Communication {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;

    private Communication() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Response login(Administrator administrator) throws Exception {
        Request request = new Request(Operation.LOGIN, administrator);

        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getResponseStatus().equals(ResponseStatus.Success)) {
            return response;
        } else {
            return response;
        }
    }

    public Response logoff(Administrator administrator) throws Exception {
        Request request = new Request(Operation.LOGOFF, administrator);

        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getResponseStatus().equals(ResponseStatus.Success)) {
            return response;
        } else {
            return response;
        }
    }

    public List<MemberType> getAllMemberType() throws Exception {
        Request request = new Request(Operation.GET_ALL_MEMBER_TYPE, null);
        return (List<MemberType>) sendRequest(request);
    }

    public List<Author> getAllAuthors() throws Exception {
        Request request = new Request(Operation.GET_ALL_AUTHOR, null);
        return (List<Author>) sendRequest(request);
    }

    public List<Member> getAllMembers() throws Exception {
        Request request = new Request(Operation.GET_ALL_MEMBERS, null);
        return (List<Member>) sendRequest(request);
    }

    public List<Book> getAllBooks() throws Exception {
        Request request = new Request(Operation.GET_ALL_BOOKS, null);
        return (List<Book>) sendRequest(request);
    }

    public List<Rental> getAllRentals() throws Exception {
        Request request = new Request(Operation.GET_ALL_RENTALS, null);
        return (List<Rental>) sendRequest(request);
    }

    public List<Rental> getAllRentalsByMember(Member member) throws Exception {
        Request request = new Request(Operation.GET_ALL_RENTALS_BY_MEMBER, member);
        return (List<Rental>) sendRequest(request);
    }


    public Author addAuthor(Author author) throws Exception {
        Request request = new Request(Operation.ADD_AUTHOR, author);
        return (Author) sendRequest(request);
    }

    public Member addMember(Member member) throws Exception {
        Request request = new Request(Operation.ADD_MEMBER, member);
        return (Member) sendRequest(request);
    }

    public Book addBook(Book book) throws Exception {
        Request request = new Request(Operation.ADD_BOOK, book);
        return (Book) sendRequest(request);
    }

    public Rental addRental(Rental rental) throws Exception {
        Request request = new Request(Operation.ADD_RENTAL, rental);
        return (Rental) sendRequest(request);
    }

    public Response deleteMember(Member member) throws Exception {

        Request request = new Request(Operation.DELETE_MEMBER, member);
        sender.send(request);
        Response response = (Response) receiver.receive();

        return response;
    }

    public Response deleteBook(Book book) throws Exception {
        Request request = new Request(Operation.DELETE_BOOK, book);
        sender.send(request);
        Response response = (Response) receiver.receive();

        return response;
    }

    public Response deleteAutor(Author author) throws Exception {
        Request request = new Request(Operation.DELETE_AUTHOR, author);
        sender.send(request);
        Response response = (Response) receiver.receive();
        return response;
    }

    public void editMember(Member member) throws Exception {
        Request request = new Request(Operation.EDIT_MEMBER, member);
        sendRequest(request);
    }

    public void editBook(Book book) throws Exception {
        Request request = new Request(Operation.EDIT_BOOK, book);
        sendRequest(request);
    }

    public void editAuthor(Author author) throws Exception {
        Request request = new Request(Operation.EDIT_AUTHOR, author);
        sendRequest(request);
    }

    public void editRental(Rental rental) throws Exception {
        Request request = new Request(Operation.EDIT_RENTAL, rental);
        sendRequest(request);
    }

    private Object sendRequest(Request request) throws Exception {
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getResponseStatus().equals(ResponseStatus.Success)) {
            return response.getResult();
        } else {
            return response;
        }
    }

}
