package com.example.silkroad;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NotificationHandler {

    private static Timeline timeline;

    public NotificationHandler() {
        timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    notification();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }) , new KeyFrame(Duration.seconds(5)));
        timeline.setCycleCount(Animation.INDEFINITE);
    }


    public void stop() {
        timeline.stop();
    }

    public void start() {
        timeline.play();
    }

    public static Timeline getTimeline() {
        return timeline;
    }

    public static synchronized void notification() throws IOException {
        int size = new NotificationChat().getNotifications(new AccountHandler().getAccount().getDatabaseID());
        if (size != 0) {
            PageController.open("Notification");
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.schedule(
                    new Runnable() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run()  {
                                    PageController.close();
                                }
                            });
                        }
                    }, 4, TimeUnit.SECONDS);
        }
    }


}
