package com.example.silkroad;

import ADS.Vehicle.Car;
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

public class ShowADCarLightController implements Initializable {

    @FXML
    private Button chatBox;

    @FXML
    private Label city;

    @FXML
    private Label color;

    @FXML
    private Button contact;

    @FXML
    private Label description;

    @FXML
    private Label hasPaint;

    @FXML
    private ImageView image;

    @FXML
    private Label kilometer;

    @FXML
    private Label price;

    @FXML
    private Label title;

    @FXML
    private Label year;

    @FXML
    void backADS(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ADsPageLight");
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AdsNumberHandler.start = 0;
        AdsNumberHandler.end = 8;
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.pageCounter = 0;

        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        AdsNumberHandler.start = 0;
        AdsNumberHandler.end = 8;
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.pageCounter = 0;

        PageController.close();
        PageController.open("ProfileLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ShowADCarDark");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (new AccountHandler().getAccount().getDatabaseID() == AdsNumberHandler.car.getDatabaseID())
        {
            chatBox.setDisable(true);
        }else {
            chatBox.setDisable(false);
        }

        Car ad = AdsNumberHandler.car;

        title.setText(ad.getTitle());
        price.setText(ad.getPrice());
        city.setText(ad.getCity());
        description.setText(ad.getDescription());
        color.setText(ad.getColor());
        year.setText(String.valueOf(ad.getYearOfBuild()));
        kilometer.setText(String.valueOf(ad.getKilometer()));
        if (ad.isHasPaintJob())
        {
            hasPaint.setText("YES");
        }else {
            hasPaint.setText("NO");
        }

        try {
            getPicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookmark(ActionEvent event) throws IOException {
        int adID = AdsNumberHandler.car.getDatabaseID();
        int userId = new AccountHandler().getAccount().getDatabaseID();

        AdsNumberHandler.add_delete_bookmark(adID, userId);
    }

    public void chatBox(ActionEvent event) throws IOException {
        int receiverID = AdsNumberHandler.car.getOwnerID();
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(), new AccountHandler().getAccount().getDatabaseID()
                , receiverID);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    public synchronized void getPicture() throws IOException {
        String dataToServer = new JsonHandler().getAdPicture(AdsNumberHandler.car.getDatabaseID());
        output.write(dataToServer);
        output.newLine();
        output.flush();
        String path = ImageHandler.receiveUserImage();
        File file = new File(path);
        Image image1 = new Image(file.toURL().toString());
        image.setImage(image1);
    }
}
