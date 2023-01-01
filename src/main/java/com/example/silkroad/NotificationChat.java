package com.example.silkroad;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NotificationChat {
    private static CreateSocket createSocket;
    private static BufferedWriter output;
    private static BufferedReader input;
    private static ArrayList<TextMessage> mainList;

    public NotificationChat() {
        createSocket = new CreateSocket();
        output = createSocket.getOutput();
        input = createSocket.getInput();
    }

    public synchronized int getNotifications(int receiverID) throws IOException {
        ArrayList<TextMessage> list = new ArrayList<>();
        output.write(new JsonHandler().getNotifications(receiverID));
        output.newLine();
        output.flush();

        String temp = input.readLine();
        int size = Integer.parseInt(temp);
        Gson gson = new Gson();
        for (int i = 0; i < size; i++) {
            list.add(gson.fromJson(input.readLine(), TextMessage.class));
            System.out.println(list.get(i));
        }
        mainList = new ArrayList<>(list);
        return size;
    }

    public ArrayList<TextMessage> getMainList() {
        return mainList;
    }
}
