package org.example;

import com.google.gson.Gson;

public class CommandHandler {

    private final Piatto[] testData = Piatto.testData();
    private final Gson gson = new Gson();

    public CommandHandler(){
    }

    public String execute(String cmd){
        String response;

        switch (cmd){
            case "all":
                response = gson.toJson(testData);
                break;

            default:
                response = "ERROR: command doesn't exist";
                break;
        }

        return response;
    }
}
