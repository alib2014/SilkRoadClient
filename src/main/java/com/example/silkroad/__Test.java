package com.example.silkroad;

import ADS.AD;
import ADS.Appliances.Appliances;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class __Test {
    public static class doIt extends TimerTask {
        private ArrayList<TextMessage> list = new ArrayList<>();
        public void run() {
            list = new ChatHandler().listenForMessage();
        }

        public ArrayList<TextMessage> getList() {
            return list;
        }
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<TextMessage> list = new ArrayList<>();
//        CreateSocket createSocket = new CreateSocket();

        Appliances appliances = new Appliances("2", "a", "f", "d", 11, true, "n");
        String ad = new Gson().toJson(appliances);

        AD ad2 = func(ad, Appliances.class);
        System.out.println(ad2.getPrice());
//        list = new NotificationChat().getNotifications(11);
//        for (TextMessage x : list) {
//            System.out.println("sender is : " + x.getSenderUsername());
//            System.out.println("content is : " + x.getContent());
//            System.out.println("date is : " + x.getDate());
//        }
//        ChatHandler chatHandler = new ChatHandler(socket, 1); // enter receiverID
//        chatHandler.getAllMessages();
//        Timer timer = new Timer();
//        doIt doIt = new doIt();
//        timer.schedule(doIt, 2000, 12000);
//        list = doIt.getList();
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter your text : ");
//            String text = scanner.nextLine();
//            chatHandler.sendMessage(text);
//        }
    }

    public static AD func(String ad, Class tClass) {
        AD Ad = (AD) new Gson().fromJson(ad, tClass);
        return Ad;
    }
}
