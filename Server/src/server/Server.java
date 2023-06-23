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

    public Server() throws IOException {
        try {
            serverSocket = new ServerSocket(9000);
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
        processClientRequests.start();
        
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

}
