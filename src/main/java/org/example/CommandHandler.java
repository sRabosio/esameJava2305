package org.example;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class CommandHandler {

    private final Piatto[] testData = Piatto.testData();
    private final Gson gson = new Gson();
    private TcpConnection conn;

    public CommandHandler(TcpConnection conn) {
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

            case "all_sorted", "asort":
                response = gson.toJson(allSorted(testData));
                break;

            case "most_expensive", "exp":
                response = gson.toJson(mostExpensive(testData));
                break;

            default:
                response = "ERROR: command doesn't exist";
                break;
        }

        return response;
    }

    //ordina i piatti in ordine crescente
    private ArrayList<Piatto> allSorted(Piatto[] array){
        ArrayList<Piatto> result = new ArrayList<>(List.of(array));
        Piatto temp;
        boolean exit = true;
        while(exit) {
            for (int i = 1; i < result.size(); i++) {
                exit = false;
                if (result.get(i).expensive(result.get(i - 1)) < 1) {
                    temp = result.get(i);
                    result.set(i,
                            result.get(i - 1));
                    result.set(i - 1, temp);
                    exit = true;
                }
            }
        }

        return result;
    }

    //returns the most expensive element
    private Piatto mostExpensive(Piatto[] array){
        Piatto expensive = null;

        if(array == null ) return null;
        expensive = array[0];
        if(array.length == 1) return expensive;

        for(Piatto p:array){
            if(expensive.expensive(p) < 1)
                expensive = p;
        }
        return expensive;
    }
}
