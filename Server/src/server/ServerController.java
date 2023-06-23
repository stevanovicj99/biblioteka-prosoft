package server;

import controller.Controller;
import domain.Administrator;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ProcessClientRequests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Jelena
 */
public class ServerController {

    private static ServerController instance;
    ArrayList<Administrator> listOfPossibleAdministrators;
    ArrayList<Administrator> activeAdministrators = new ArrayList<>();
    ArrayList<Socket> listOfAdministrators = new ArrayList<>();

    private ServerController() {
        try {
            listOfPossibleAdministrators = Controller.getInstance().getAllAdministrators();
        } catch (Exception ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addAdministrator(Socket socket) {
        listOfAdministrators.add(socket);
    }

    public void cancelClients() {
        for (Socket s : listOfAdministrators) {
            try {
                s.close();
                listOfAdministrators.remove(s);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Socket> getListOfAdministrators() {
        return listOfAdministrators;
    }

    public void addActiveAdministrator(Administrator administrator) {
        activeAdministrators.add(administrator);
    }

    public boolean isItActive(Administrator administrator) {
        for (Administrator admin : activeAdministrators) {
            if (admin.getUsername().equals(administrator.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Administrator> getActiveAdministrators() {
        return activeAdministrators;
    }

    public boolean isTheUsernameCorrect(Administrator administrator) throws Exception {
        for (Administrator admin : listOfPossibleAdministrators) {
            if (admin.getUsername().equals(administrator.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isThePasswordCorrect(Administrator administrator) throws Exception {
        for (Administrator admin : listOfPossibleAdministrators) {
            if (admin.getPassword().equals(administrator.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Administrator returnSpecificAdministrator(Administrator administrator) {

        for (Administrator admin : listOfPossibleAdministrators) {
            if (admin.getUsername().equals(administrator.getUsername())) {
                return admin;
            }
        }
        return null;
    }

    public boolean removeSpecificAdministrator(Administrator administrator) {
        for (Administrator admin : activeAdministrators) {
            if (admin.equals(administrator)) {
                System.out.println(admin);
                return activeAdministrators.remove(admin);
            }
        }
        return false;
    }

}
