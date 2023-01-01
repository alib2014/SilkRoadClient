package com.example.silkroad;

import ADS.AD;
import ADS.Vehicle.Bike;
import ADS.Vehicle.Car;
import ADS.Vehicle.Motorcycle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class CreateADVehicleDarkController {

    @FXML
    private Button setButton;

    @FXML
    private Label bikeSize;

    @FXML
    private Label motorKilometer;

    @FXML
    private Label carKilometer;

    @FXML
    private ImageView ADImage;

    @FXML
    private CheckBox bikeCheckBox;

    @FXML
    private TextField brandtextField;

    @FXML
    private CheckBox carCheckBox;

    @FXML
    private TextField carKilometerTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private CheckBox colorCheckBox;

    @FXML
    private TextField colorTextField;

    @FXML
    private TextField descriptionTextfield;

    @FXML
    private TextField modelTextField;

    @FXML
    private CheckBox motorCheckBox;

    @FXML
    private TextField motorKilometerTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField sizetextField;

    @FXML
    private TextField titleTextField;
    private File file = null;

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AccountHandler.setAccount(null);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("MenuDark");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ProfileDark");
    }

    @FXML
    void bike(ActionEvent event) {
        if (bikeCheckBox.isSelected()){
            motorCheckBox.setDisable(true);
            carCheckBox.setDisable(true);
            bikeSize.setDisable(false);
            sizetextField.setDisable(false);
            setButton.setDisable(false);

        } else {
            motorCheckBox.setDisable(false);
            carCheckBox.setDisable(false);
            bikeSize.setDisable(true);
            sizetextField.setDisable(true);
            setButton.setDisable(true);
        }
    }

    @FXML
    void car(ActionEvent event) {
        if (carCheckBox.isSelected()){
            motorCheckBox.setDisable(true);
            bikeCheckBox.setDisable(true);
            carKilometer.setDisable(false);
            carKilometerTextField.setDisable(false);
            colorCheckBox.setDisable(false);
            setButton.setDisable(false);
        } else {
            motorCheckBox.setDisable(false);
            bikeCheckBox.setDisable(false);
            carKilometer.setDisable(true);
            carKilometerTextField.setDisable(true);
            colorCheckBox.setDisable(true);
            setButton.setDisable(true);
        }
    }

    @FXML
    void motor(ActionEvent event) {
        if (motorCheckBox.isSelected()){
            carCheckBox.setDisable(true);
            bikeCheckBox.setDisable(true);
            motorKilometer.setDisable(false);
            motorKilometerTextField.setDisable(false);
            setButton.setDisable(false);
        } else {
            carCheckBox.setDisable(false);
            bikeCheckBox.setDisable(false);
            motorKilometer.setDisable(true);
            motorKilometerTextField.setDisable(true);
            setButton.setDisable(true);
        }
    }

    @FXML
    void setAD(ActionEvent event) throws IOException {

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        AccountHandler accountHandler = new AccountHandler();
        int ownerID = accountHandler.getAccount().getDatabaseID();

        if (carCheckBox.isSelected())
        {
            boolean hasColor = false;
            if (colorCheckBox.isSelected())
            {
                hasColor = true;
            }

             AD ad = new Car(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                     descriptionTextfield.getText(), ownerID, Integer.parseInt(modelTextField.getText()), colorTextField.getText(),
                     brandtextField.getText(), Integer.parseInt(carKilometerTextField.getText()), hasColor);

            String dataToString = new JsonHandler().postNewAd(ad, "car");

            output.write(dataToString);
            output.newLine();
            output.flush();

        }

        else if (motorCheckBox.isSelected())
        {
            AD ad = new Motorcycle(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                    descriptionTextfield.getText(), ownerID, Integer.parseInt(modelTextField.getText()), brandtextField.getText(),
                    Integer.parseInt(motorKilometerTextField.getText()));

            String dataToServer = new JsonHandler().postNewAd(ad, "motorcycle");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }

        else if (bikeCheckBox.isSelected())
        {
            AD ad = new Bike(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                    descriptionTextfield.getText(), ownerID, brandtextField.getText(), Integer.parseInt(sizetextField.getText()));

            String dataToString = new JsonHandler().postNewAd(ad, "bike");

            output.write(dataToString);
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
        PageController.open("CreateNewADBasicDark");
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
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateAdVehicleLight");
    }

}
