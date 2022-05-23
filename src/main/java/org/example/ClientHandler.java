package org.example;

import java.net.Socket;

public class ClientHandler implements Runnable{
    private TcpConnection conn;
    private final CommandHandler cmdh;

    public ClientHandler(Socket sock){
        System.out.println("--conneting to "+sock.getRemoteSocketAddress() + "...");
        conn = new TcpConnection(sock);
        cmdh = new CommandHandler(conn);
        System.out.println("--connection established!");
    }

    @Override
    public void run() {
            for(String s; (s = conn.read()) != null;) {
                conn.write(
                        cmdh.execute(s)+"\n"
                );
            }
    }
}
