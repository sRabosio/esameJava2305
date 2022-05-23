package org.example;

import com.sun.security.ntlm.Client;

import java.io.IOException;
import java.net.ServerSocket;

import static java.lang.System.exit;

public class Server {
    private static int port = 1234;
    private static ServerSocket server;

    public static void main(String[] args){
        initServer();
        waitClients();
    }

    private static void initServer(){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            exit(-1);
        }
        System.out.println("--server started");
    }

    private static void waitClients(){
        System.out.println("--waiting clients");
        try {
            new Thread(new ClientHandler(
                    server.accept()
            ));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            exit(-1);
        }
    }
}
