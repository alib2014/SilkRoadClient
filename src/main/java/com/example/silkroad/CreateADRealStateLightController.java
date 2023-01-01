package com.example.silkroad;

import ADS.AD;
import ADS.RealEstate.Building;
import ADS.RealEstate.Land;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class CreateADRealStateLightController {

    @FXML
    private Label yearLabel;

    @FXML
    private ImageView ADImage;

    @FXML
    private TextField areaTextField;

    @FXML
    private CheckBox buildingCheckBox;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField descriptionTextfield;

    @FXML
    private TextField priceTextField;

    @FXML
    private CheckBox storeCheckBox;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField yearTextField;
    private File file = null;

    @FXML
    void isBuilding(ActionEvent event){
        if (buildingCheckBox.isSelected()){
            yearTextField.setDisable(false);
            storeCheckBox.setDisable(false);
            yearLabel.setDisable(false);
        } else {
            yearTextField.setDisable(true);
            storeCheckBox.setDisable(true);
            yearLabel.setDisable(true);
        }
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AccountHandler.setAccount(null);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ProfileLight");
    }

    @FXML
    void setAD(ActionEvent event) throws IOException {
        int ownerID = new AccountHandler().getAccount().getDatabaseID();

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        if (buildingCheckBox.isSelected())
        {
            boolean store = false;
            if (storeCheckBox.isSelected())
            {
                store = true;
            }

            AD ad = new Building(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                    descriptionTextfield.getText(), ownerID, Double.parseDouble(areaTextField.getText()),
                    Integer.parseInt(yearTextField.getText()), store);

            String dataToServer = new JsonHandler().postNewAd(ad, "building");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }else {
            AD ad = new Land(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                    descriptionTextfield.getText(), ownerID, Double.parseDouble(areaTextField.getText()));

            String dataToServer = new JsonHandler().postNewAd(ad, "land");

            output.write(dataToServer);
            output.newLine();
            output.flush();
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int id = Integer.parseInt(input.readLine());

        if (file != null) {
            String dataToServer = new JsonHandler().saveAdPicture(id);
            output.write(dataToServer);
            output.newLine();
            output.flush();
            ImageHandler imageHandler = new ImageHandler(file, id);
            imageHandler.sendImage();
        }

        PageController.close();
        PageController.open("CreateNewADBasicLight");
    }

    @FXML
    void setPicture(ActionEvent event) throws FileNotFoundException, MalformedURLException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose your picture");
        File file = fileChooser.showOpenDialog(stage);
        Image image = new Image(file.toURL().toString());
        ADImage.setImage(image);
        this.file = file;
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADRealStateBasicDark");
    }

}
