package org.example;

import com.google.gson.Gson;

public class CommandHandler {

    private final Piatto[] testData = Piatto.testData();
    private final Gson gson = new Gson();
    private TcpConnection conn;

    public CommandHandler(TcpConnection conn){
        this.conn = conn;
    }

    public String execute(String cmd){
        String response = null;

        switch (cmd){
            case "all":
                response = gson.toJson(testData);
                break;

            case "quit", "q":
                conn.close();
                break;

            default:
                response = "ERROR: command doesn't exist";
                break;
        }

        return response;
    }
}
