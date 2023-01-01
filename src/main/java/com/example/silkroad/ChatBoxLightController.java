package com.example.silkroad;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatBoxLightController implements Initializable {
    private Timeline timeline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChatHandler chatHandler = new ChatHandler();
        ArrayList<TextMessage> defaultList = chatHandler.getAllMessages();
        for (TextMessage x : defaultList) {
            if (x.getSenderID() == new AccountHandler().getAccount().getDatabaseID()) {
                String message = x.getContent();
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.setPadding(new Insets(5, 5, 5, 10));
                Text text = new Text(message);
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-padding: 5px; -fx-background-color: lightblue; -fx-background-radius: 10");
                hBox.getChildren().add(textFlow);
                vBox.getChildren().add(hBox);
                scroll.vvalueProperty().bind(vBox.heightProperty());
            } else {
                String message = x.getContent();
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setPadding(new Insets(5, 5, 5, 10));
                Text text = new Text(message);
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-padding: 5px; -fx-background-color: lightgreen; -fx-background-radius: 10");
                hBox.getChildren().add(textFlow);
                vBox.getChildren().add(hBox);
                scroll.vvalueProperty().bind(vBox.heightProperty());
            }
        }
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> receive()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public synchronized void receive() {
        ArrayList<TextMessage> newMessages = new ChatHandler().listenForMessage();
        for (TextMessage x : newMessages) {
            String message = x.getContent();
            System.out.println("Text is : " + message);
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            Text text = new Text(message);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-padding: 5px; -fx-background-color: lightgreen; -fx-background-radius: 10");
            hBox.getChildren().add(textFlow);
            vBox.getChildren().add(hBox);
            scroll.vvalueProperty().bind(vBox.heightProperty());
        }
    }




    @FXML
    private TextField messageTextField;

    @FXML
    private Label accountName;

    @FXML
    private VBox vBox;

    @FXML
    private ScrollPane scroll;

    @FXML
    void send(ActionEvent event) {
        String message = messageTextField.getText();
        if (message != null) {
            messageTextField.clear();
            new ChatHandler().sendMessage(message);
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_RIGHT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            Text text = new Text(message);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-padding: 5px; -fx-background-color: lightblue; -fx-background-radius: 10");
            hBox.getChildren().add(textFlow);
            vBox.getChildren().add(hBox);
            scroll.vvalueProperty().bind(vBox.heightProperty());
        }
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ChatBoxDark");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.suggestedADs.clear();

        NotificationHandler.getTimeline().play();
        timeline.stop();
        PageController.close();
        PageController.open("ProfileLight");
    }

}

