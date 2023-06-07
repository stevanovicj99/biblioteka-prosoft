/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import domain.Administrator;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ProcessClientRequests;

/**
 *
 * @author Jelena
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
//    List<ProcessClientRequests> activeClients;
//
//    ArrayList<Administrator> listOfPossibleAdministrators;
//    ArrayList<Administrator> activeAdministrators;
//    ArrayList<Socket> listOfAdministrators;

    public Server() throws IOException {
        try {
            serverSocket = new ServerSocket(9000);
//            listOfPossibleAdministrators = Controller.getInstance().getAllAdministrators();
//            activeAdministrators = new ArrayList<>();
//            listOfAdministrators = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected!");
                handleClient(socket);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        ServerController.getInstance().cancelClients();
    }

    private void handleClient(Socket socket) throws Exception {
        ServerController.getInstance().addAdministrator(socket);
        ProcessClientRequests processClientRequests = new ProcessClientRequests(socket);
//        activeClients.add(processClientRequests);
        processClientRequests.start();
        
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    /*public List<Administrator> getActiveAdministrators() {
        List<Administrator> administrators = new ArrayList<>();
        for (ProcessClientRequests pcr : activeClients) {
            administrators.add(pcr.getAdministrator());
        }
        return administrators;
    }*/
 /*private void cancelClients() {
           for (Socket s : listOfAdministrators) {
            try {
                s.close();
                listOfAdministrators.remove(s);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addAdministrator(Socket socket) {
        listOfAdministrators.add(socket);
    }

    public ArrayList<Socket> getListOfAdministrators() {
        return listOfAdministrators;
    }

    public void addActiveAdministrator(Administrator administrator) {
        activeAdministrators.add(administrator);
    }

    public boolean isItActive(Administrator administrator) {
        return activeAdministrators.contains(administrator);
    }

    public ArrayList<Administrator> getActiveAdministrators() {
        return activeAdministrators;
    }

    public boolean isTheUsernameCorrect(Administrator administrator) throws Exception {
        List<Administrator> list = Controller.getInstance().getAllAdministrators();

        for (Administrator admin : list) {
            if (admin.getUsername().equals(administrator.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isThePasswordCorrect(Administrator administrator) throws Exception {
        List<Administrator> list = Controller.getInstance().getAllAdministrators();

        for (Administrator admin : list) {
            if (admin.getPassword().equals(administrator.getPassword())) {
                return true;
            }
        }
        return false;
    }*/
}
