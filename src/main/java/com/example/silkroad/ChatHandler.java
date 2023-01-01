package com.example.silkroad;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatHandler {
    private static Socket socket;
    private static BufferedReader input;
    private static BufferedWriter output;
    private static int senderID;
    private static int receiverID;

    public ChatHandler(Socket socket, int senderID, int receiverID) {
        try {
            ChatHandler.socket = socket;
            ChatHandler.input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            ChatHandler.output = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            ChatHandler.senderID = senderID;
            ChatHandler.receiverID = receiverID;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChatHandler() {

    }

    public void sendMessage(String message) {
        try {
            String dataToServer = new JsonHandler().sendMessage(new TextMessage(senderID, receiverID, message));
            output.write(dataToServer);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TextMessage> listenForMessage() {
        ArrayList<TextMessage> list = new ArrayList<>();
        try {
            String dataToServer = new JsonHandler().loadNewMessages(receiverID, senderID);
            output.write(dataToServer);
            output.newLine();
            output.flush();
            String message;
            String data = input.readLine();
            int size = Integer.parseInt(data);
            Gson gson = new Gson();
            for (int i = 0; i < size; i++) {
                message = input.readLine();
                list.add(gson.fromJson(message, TextMessage.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<TextMessage> getAllMessages() {
        ArrayList<TextMessage> list = new ArrayList<>();
        try {
            String dataToServer = new JsonHandler().getMyMessages(senderID, receiverID);
            output.write(dataToServer);
            output.newLine();
            output.flush();
            String message;
            String data = input.readLine();
            int size = Integer.parseInt(data);
            Gson gson = new Gson();
            for (int i = 0; i < size; i++) {
                message = input.readLine();
                list.add(gson.fromJson(message, TextMessage.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
