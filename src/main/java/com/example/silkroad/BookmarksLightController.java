package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.silkroad.CreateSocket.output;

public class BookmarksLightController implements Initializable {

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
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;

    @FXML
    private Pane pane6;

    @FXML
    private Pane pane7;

    @FXML
    private Pane pane8;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label price3;

    @FXML
    private Label price4;

    @FXML
    private Label price5;

    @FXML
    private Label price6;

    @FXML
    private Label price7;

    @FXML
    private Label price8;

    @FXML
    private Label title1;

    @FXML
    private Label title2;

    @FXML
    private Label title3;

    @FXML
    private Label title4;

    @FXML
    private Label title5;

    @FXML
    private Label title6;

    @FXML
    private Label title7;

    @FXML
    private Label title8;

    @FXML
    private Button nextButton;

    @FXML
    private Button lastButton;

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
    void backPro(ActionEvent event) throws IOException {
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
        PageController.open("BookmarksDark");
    }

    @FXML
    void lastPage(ActionEvent event) throws IOException {
        AdsNumberHandler.decrease();
        AdsNumberHandler.pageCounter--;

        AdsNumberHandler.ADsToShow.clear();

        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().getBookmarks(id);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        AdsNumberHandler.getAds();

        PageController.close();
        PageController.open("BookMarksLight");
    }

    @FXML
    void nextPage(ActionEvent event) throws IOException {
        AdsNumberHandler.increase();
        AdsNumberHandler.pageCounter++;

        AdsNumberHandler.ADsToShow.clear();

        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().getBookmarks(id);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        AdsNumberHandler.getAds();

        PageController.close();
        PageController.open("BookMarksLight");
    }


    @FXML
    void openAD1(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(0).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(0);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD2(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(1).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(1);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD3(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(2).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(2);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD4(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(3).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(3);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD5(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(4).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(4);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD6(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(5).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(5);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD7(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(6).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(6);
        openAdsPage(AdsNumberHandler.category);
    }

    @FXML
    void openAD8(MouseEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        AdsNumberHandler.addToHistory(AdsNumberHandler.ADsToShow.get(7).getDatabaseID(),
                accountHandler.getAccount().getDatabaseID());
        AdsNumberHandler.getSpecificAd(7);
        openAdsPage(AdsNumberHandler.category);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if ((int) (Math.ceil(AdsNumberHandler.totalSize / 8)) == AdsNumberHandler.pageCounter){
            nextButton.setDisable(true);
        } else {
            nextButton.setDisable(false);
        }
        if (AdsNumberHandler.start == 0){
            lastButton.setDisable(true);
        } else {
            lastButton.setDisable(false);
        }

        if (AdsNumberHandler.ADsToShow.get(0) != null){
            title1.setText(AdsNumberHandler.ADsToShow.get(0).getTitle());
            price1.setText(AdsNumberHandler.ADsToShow.get(0).getPrice());
            try {
                getPicture(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title1.setVisible(false);
            price1.setVisible(false);
            image1.setVisible(false);
            pane1.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(1) != null){
            title2.setText(AdsNumberHandler.ADsToShow.get(1).getTitle());
            price2.setText(AdsNumberHandler.ADsToShow.get(1).getPrice());
            try {
                getPicture(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title2.setVisible(false);
            price2.setVisible(false);
            image2.setVisible(false);
            pane2.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(2) != null){
            title3.setText(AdsNumberHandler.ADsToShow.get(2).getTitle());
            price3.setText(AdsNumberHandler.ADsToShow.get(2).getPrice());
            try {
                getPicture(2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title3.setVisible(false);
            price3.setVisible(false);
            image3.setVisible(false);
            pane3.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(3) != null){
            title4.setText(AdsNumberHandler.ADsToShow.get(3).getTitle());
            price4.setText(AdsNumberHandler.ADsToShow.get(3).getPrice());
            try {
                getPicture(3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title4.setVisible(false);
            price4.setVisible(false);
            image4.setVisible(false);
            pane4.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(4) != null){
            title5.setText(AdsNumberHandler.ADsToShow.get(4).getTitle());
            price5.setText(AdsNumberHandler.ADsToShow.get(4).getPrice());
            try {
                getPicture(4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title5.setVisible(false);
            price5.setVisible(false);
            image5.setVisible(false);
            pane5.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(5) != null){
            title6.setText(AdsNumberHandler.ADsToShow.get(5).getTitle());
            price6.setText(AdsNumberHandler.ADsToShow.get(5).getPrice());
            try {
                getPicture(5);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title6.setVisible(false);
            price6.setVisible(false);
            image6.setVisible(false);
            pane6.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(6) != null){
            title7.setText(AdsNumberHandler.ADsToShow.get(6).getTitle());
            price7.setText(AdsNumberHandler.ADsToShow.get(6).getPrice());
            try {
                getPicture(6);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title7.setVisible(false);
            price7.setVisible(false);
            image7.setVisible(false);
            pane7.setVisible(false);
        }
        if (AdsNumberHandler.ADsToShow.get(7) != null){
            title8.setText(AdsNumberHandler.ADsToShow.get(7).getTitle());
            price8.setText(AdsNumberHandler.ADsToShow.get(7).getPrice());
            try {
                getPicture(7);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            title8.setVisible(false);
            price8.setVisible(false);
            image8.setVisible(false);
            pane8.setVisible(false);
        }
    }

    public synchronized void openAdsPage (String category) throws IOException {
        switch (category) {
            case "Appliance": {
                PageController.close();
                PageController.open("ShowADAppliancesLight");
                break;
            }
            case "Computer" : {
                PageController.close();
                PageController.open("ShowADComputerLight");
                break;
            }
            case "DigitalAccessories": {
                PageController.close();
                PageController.open("ShowADDigitalAccessoriesLight");
                break;
            }
            case "DigitalAppliance": {
                PageController.close();
                PageController.open("ShowADDigitalAppliencesLight");
                break;
            }
            case "GamingConsole": {
                PageController.close();
                PageController.open("ShowADGamingLight");
                break;
            }
            case "PhoneAndTablet": {
                PageController.close();
                PageController.open("ShowADPhoneLight");
                break;
            }
            case "IndustrialEquipment": {
                PageController.close();
                PageController.open("ShowADIndustrialEquipmentLight");
                break;
            }
            case "PersonalItem": {
                PageController.close();
                PageController.open("ShowADPersonalItemLight");
                break;
            }
            case "Building" : {
                PageController.close();
                PageController.open("ShowADBuildingLight");
                break;
            }
            case "Land" : {
                PageController.close();
                PageController.open("ShowADLLandLight");
                break;
            }
            case "Bike" : {
                PageController.close();
                PageController.open("ShowADBikeLight");
                break;
            }
            case "Car" : {
                PageController.close();
                PageController.open("ShowADCarLight");
                break;
            }
            case "Motorcycle" : {
                PageController.close();
                PageController.open("ShowADMotorLight");
                break;
            }
        }
    }

    public synchronized void getPicture(int i) throws IOException {
        String dataToServer = new JsonHandler().getAdPicture(AdsNumberHandler.ADsToShow.get(i).getDatabaseID());
        output.write(dataToServer);
        output.newLine();
        output.flush();
        String path = ImageHandler.receiveUserImage();
        File file = new File(path);
        Image image = new Image(file.toURL().toString());
        if (i == 0){
            image1.setImage(image);
        } else if (i == 1) {
            image2.setImage(image);
        } else if (i == 2) {
            image3.setImage(image);
        } else if (i == 3) {
            image4.setImage(image);
        } else if (i == 4) {
            image5.setImage(image);
        } else if (i == 5) {
            image6.setImage(image);
        } else if (i == 6) {
            image7.setImage(image);
        } else if (i == 7) {
            image8.setImage(image);
        }
    }

}

