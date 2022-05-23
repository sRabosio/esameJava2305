package org.example;

import java.io.IOException;
import java.net.ServerSocket;

import static java.lang.System.exit;

public class Server {
    private static int port = 1234;
    private static ServerSocket server;

    public static void main(String[] args){

    }

    private static void initServer(){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            exit(-1);
        }
    }
}
