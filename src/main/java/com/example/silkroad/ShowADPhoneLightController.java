package com.example.silkroad;

import ADS.DigitalGoods.PhoneAndTablet;
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

public class ShowADPhoneLightController implements Initializable {

    @FXML
    private Label brand;

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
    private ImageView image;

    @FXML
    private Label isnew;

    @FXML
    private Label memory;

    @FXML
    private Label price;

    @FXML
    private Label ram;

    @FXML
    private Label sim;

    @FXML
    private Label title;

    @FXML
    void backADS(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ADsPageLight");
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AdsNumberHandler.ADsToShow.clear();
        AdsNumberHandler.pageCounter = 0;
        AdsNumberHandler.start = 0;
        AdsNumberHandler.end = 8;

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
        PageController.open("ShowADPhoneDark");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (new AccountHandler().getAccount().getDatabaseID() == AdsNumberHandler.phoneAndTablet.getDatabaseID())
        {
            chatBox.setDisable(true);
        }else {
            chatBox.setDisable(false);
        }

        PhoneAndTablet ad = AdsNumberHandler.phoneAndTablet;

        brand.setText(ad.getBrand());
        title.setText(ad.getTitle());
        price.setText(ad.getPrice());
        city.setText(ad.getCity());
        color.setText(ad.getColor());
        ram.setText(String.valueOf(ad.getRAM()));
        memory.setText(String.valueOf(ad.getMemory()));
        sim.setText(String.valueOf(ad.getNumberOfSIMCards()));
        description.setText(ad.getDescription());
        if (ad.isNew())
        {
            isnew.setText("YES");
        }else
        {
            isnew.setText("NO");
        }
        try {
            getPicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookmark(ActionEvent event) throws IOException {
        int adID = AdsNumberHandler.phoneAndTablet.getDatabaseID();
        int userId = new AccountHandler().getAccount().getDatabaseID();

        AdsNumberHandler.add_delete_bookmark(adID, userId);
    }

    public void chatBox(ActionEvent event) throws IOException {
        int receiverID = AdsNumberHandler.phoneAndTablet.getOwnerID();
        ChatHandler chatHandler = new ChatHandler(new CreateSocket().getSocket(), new AccountHandler().getAccount().getDatabaseID()
                , receiverID);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("ChatBoxLight");
    }

    public synchronized void getPicture() throws IOException {
        String dataToServer = new JsonHandler().getAdPicture(AdsNumberHandler.phoneAndTablet.getDatabaseID());
        output.write(dataToServer);
        output.newLine();
        output.flush();
        String path = ImageHandler.receiveUserImage();
        File file = new File(path);
        Image image1 = new Image(file.toURL().toString());
        image.setImage(image1);
    }

}
