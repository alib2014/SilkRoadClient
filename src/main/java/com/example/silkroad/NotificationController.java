package com.example.silkroad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NotificationController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private ScrollPane scroll;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<TextMessage> defaultList = new NotificationChat().getMainList();
        for (TextMessage y : defaultList) {
            System.out.println(y);
        }
        for (TextMessage x : defaultList) {
            String name = x.getSenderUsername();
            String date = String.valueOf(x.getDate());
            String content = x.getContent();
            HBox nameHBox = new HBox();
            HBox dateHBox = new HBox();
            HBox contentHBox = new HBox();
            nameHBox.setAlignment(Pos.TOP_LEFT);
            dateHBox.setAlignment(Pos.BOTTOM_RIGHT);
            contentHBox.setAlignment(Pos.CENTER);
            contentHBox.setPadding(new Insets(5, 5, 5, 10));
            dateHBox.setPadding(new Insets(5, 5, 5, 10));
            nameHBox.setPadding(new Insets(5, 5, 5, 10));
            Text nameText = new Text(name);
            Text dateText = new Text(date);
            Text contentText = new Text(content);
            TextFlow nameTextFlow = new TextFlow(nameText);
            nameTextFlow.setStyle("-fx-padding: 5px; -fx-background-color: red; -fx-background-radius: 20");
            TextFlow dateTextFlow = new TextFlow(dateText);
            dateTextFlow.setStyle("-fx-padding: 5px; -fx-background-color: green; -fx-background-radius: 20");
            TextFlow contentTextFlow = new TextFlow(contentText);
            contentTextFlow.setStyle("-fx-padding: 5px; -fx-background-color: blue; -fx-background-radius: 20");
            nameHBox.getChildren().add(nameTextFlow);
            dateHBox.getChildren().add(dateTextFlow);
            contentHBox.getChildren().add(contentTextFlow);
            vBox.getChildren().add(nameHBox);
            vBox.getChildren().add(contentHBox);
            vBox.getChildren().add(dateHBox);
            scroll.vvalueProperty().bind(vBox.heightProperty());

        }

    }
}
