package com.example.silkroad;

import ADS.Vehicle.Motorcycle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.silkroad.CreateSocket.output;

public class ShowADMotorDarkController implements Initializable {

    @FXML
    private Button chatBox;

    @FXML
    private Label city;

    @FXML
    private Label kilometer;

    @FXML
    private Button contact;

    @FXML
    private Label description;

    @FXML
    private ImageView image;

    @FXML
    private Label year;

    @FXML
    private Label price;

    @FXML
    private Label title;

    @FXML
    void backADS(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ADsPageDark");
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AccountHandler.setAccount(null);
        NotificationHandler.getTimeline().stop();
        AdsNumberHandler.start = 0;
        AdsNumberHandler.end = 8;
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.pageCounter = 0;

        PageController.close();
        PageController.open("MenuDark");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        AdsNumberHandler.start = 0;
        AdsNumberHandler.end = 8;
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.pageCounter = 0;

        PageController.close();
        PageController.open("ProfileDark");
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ShowADMotorLight");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (new AccountHandler().getAccount().getDatabaseID() == AdsNumberHandler.motorcycle.getOwnerID())
        {
            chatBox.setDisable(true);
        }else {
            chatBox.setDisable(false);
        }

        Motorcycle ad = AdsNumberHandler.motorcycle;

        title.setText(ad.getTitle());
        price.setText(ad.getPrice());
        city.setText(ad.getCity());
        year.setText(String.valueOf(ad.getYearOfBuild()));
        description.setText(ad.getDescription());
        kilometer.setText(String.valueOf(ad.getKilometer()));

        try {
            getPicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookmark(ActionEvent event) throws IOException {
        int adID = AdsNumberHandler.motorcycle.getDatabaseID();
        int userId = new AccountHandler().getAccount().getDatabaseID();

        AdsNumberHandler.add_delete_bookmark(adID, userId);
    }

    public void chatBox(ActionEvent event) throws IOException {
        int receiverID = AdsNumberHandler.motorcycle.getOwnerID();
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(), new AccountHandler().getAccount().getDatabaseID()
                , receiverID);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxDark");
    }

    public synchronized void getPicture() throws IOException {
        String dataToServer = new JsonHandler().getAdPicture(AdsNumberHandler.motorcycle.getDatabaseID());
        output.write(dataToServer);
        output.newLine();
        output.flush();
        String path = ImageHandler.receiveUserImage();
        File file = new File(path);
        Image image1 = new Image(file.toURL().toString());
        image.setImage(image1);
    }
}
