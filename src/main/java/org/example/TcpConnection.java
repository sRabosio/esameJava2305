package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpConnection {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public TcpConnection(Socket socket){
        setSocket(socket);
    }

    //reads string from the other side, returns null upon failure
    public String read(){
        String result = null;

        try {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //writes string to the other side
    public void write(String msg){
        writer.write(msg);
        writer.flush();
    }

    private void initWriter(){
        try {
            writer = new PrintWriter(
                    socket.getOutputStream(), true
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initReader(){
        try {
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        if(socket == null) return;
        this.socket = socket;
        initReader();
        initWriter();
    }
}
