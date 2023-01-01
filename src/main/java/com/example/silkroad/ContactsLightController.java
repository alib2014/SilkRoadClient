package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactsLightController implements Initializable {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label name3;

    @FXML
    private Label name4;

    @FXML
    private Label name5;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private AnchorPane pane4;

    @FXML
    private AnchorPane pane5;

    @FXML
    private Button nextButton;

    @FXML
    private Button lastButton;

    @FXML
    private Button chatButton1;

    @FXML
    private Button chatButton2;

    @FXML
    private Button chatButton3;

    @FXML
    private Button chatButton4;

    @FXML
    private Button chatButton5;

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ProfileLight");
    }

    @FXML
    void chat1(ActionEvent event) throws IOException {
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(),
                new AccountHandler().getAccount().getDatabaseID()
                , AdsNumberHandler.accounts.get(0).getDatabaseID());
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    @FXML
    void chat2(ActionEvent event) throws IOException {
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(),
                new AccountHandler().getAccount().getDatabaseID()
                , AdsNumberHandler.accounts.get(1).getDatabaseID());
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    @FXML
    void chat3(ActionEvent event) throws IOException {
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(),
                new AccountHandler().getAccount().getDatabaseID()
                , AdsNumberHandler.accounts.get(2).getDatabaseID());
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    @FXML
    void chat4(ActionEvent event) throws IOException {
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(),
                new AccountHandler().getAccount().getDatabaseID()
                , AdsNumberHandler.accounts.get(3).getDatabaseID());
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    @FXML
    void chat5(ActionEvent event) throws IOException {
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(),
                new AccountHandler().getAccount().getDatabaseID()
                , AdsNumberHandler.accounts.get(4).getDatabaseID());
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        AdsNumberHandler.accIncrease();
        AdsNumberHandler.pageCounter++;

        AdsNumberHandler.accounts.clear();
        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        AdsNumberHandler.getContacts(id);

        PageController.close();
        PageController.open("ContactsLight");
    }

    @FXML
    void previous(ActionEvent event) throws IOException {
        AdsNumberHandler.accDecrease();
        AdsNumberHandler.pageCounter--;

        AdsNumberHandler.accounts.clear();
        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        AdsNumberHandler.getContacts(id);

        PageController.close();
        PageController.open("ContactsLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ContactsDark");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if ((int) (Math.ceil(AdsNumberHandler.totalAccSize / 8)) == AdsNumberHandler.pageCounter){
            nextButton.setDisable(true);
        } else {
            nextButton.setDisable(false);
        }
        if (AdsNumberHandler.start == 0){
            lastButton.setDisable(true);
        } else {
            lastButton.setDisable(false);
        }

        if (AdsNumberHandler.accounts.get(0) != null){
            name1.setText(AdsNumberHandler.accounts.get(0).getName());
        } else {
            name1.setVisible(false);
            chatButton1.setVisible(false);
            image1.setVisible(false);
            pane1.setVisible(false);
        }
        if (AdsNumberHandler.accounts.get(1) != null){
            name2.setText(AdsNumberHandler.accounts.get(1).getName());
        } else {
            name2.setVisible(false);
            chatButton2.setVisible(false);
            image2.setVisible(false);
            pane2.setVisible(false);
        }
        if (AdsNumberHandler.accounts.get(2) != null){
            name3.setText(AdsNumberHandler.accounts.get(2).getName());
        } else {
            name3.setVisible(false);
            chatButton3.setVisible(false);
            image3.setVisible(false);
            pane3.setVisible(false);
        }
        if (AdsNumberHandler.accounts.get(3) != null){
            name4.setText(AdsNumberHandler.accounts.get(3).getName());
        } else {
            name4.setVisible(false);
            chatButton4.setVisible(false);
            image4.setVisible(false);
            pane4.setVisible(false);
        }
        if (AdsNumberHandler.accounts.get(4) != null){
            name5.setText(AdsNumberHandler.accounts.get(4).getName());
        } else {
            name5.setVisible(false);
            chatButton5.setVisible(false);
            image5.setVisible(false);
            pane5.setVisible(false);
        }
    }
}
