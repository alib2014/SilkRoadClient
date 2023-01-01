package com.example.silkroad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application {


    public class doIt extends TimerTask{
        public void run() {
            new ChatHandler().listenForMessage();
        }
    }

    public static void main(String[] args) {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        PageController.open("LogoShow");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run()  {
                                PageController.close();
                                try {
                                    PageController.open("MenuDark");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }, 4, TimeUnit.SECONDS);

    }
}
