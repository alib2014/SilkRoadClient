package com.example.silkroad;

import ADS.AD;
import ADS.DigitalGoods.*;
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

public class CreateADDigitalGoodsDarkController {

    private File file = null;
    @FXML
    private ImageView ADImage;

    @FXML
    private Label SIM;

    @FXML
    private TextField SIMText;

    @FXML
    private CheckBox accessoriesCheckBox;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label color;

    @FXML
    private TextField colorText;

    @FXML
    private CheckBox computerCheckBox;

    @FXML
    private CheckBox consoleCheckBox;

    @FXML
    private Label controller;

    @FXML
    private TextField controllerText;

    @FXML
    private TextField descriptionTextfield;

    @FXML
    private CheckBox digitalCheckBox;

    @FXML
    private Label graphic;

    @FXML
    private TextField graphicText;

    @FXML
    private Label memoryConsole;

    @FXML
    private TextField memoryConsoleText;

    @FXML
    private Label memoryPhone;

    @FXML
    private TextField memoryPhoneText;

    @FXML
    private CheckBox newCheckBox;

    @FXML
    private Label os;

    @FXML
    private TextField osText;

    @FXML
    private CheckBox phoneCheckBox;

    @FXML
    private TextField priceTextField;

    @FXML
    private Label ramPC;

    @FXML
    private TextField ramPCText;

    @FXML
    private Label ramPhone;

    @FXML
    private TextField ramPhoneText;

    @FXML
    private Button setADButton;

    @FXML
    private TextField titleTextField;

    @FXML
    void accessories(ActionEvent event) {
        if (accessoriesCheckBox.isSelected()){
            setADButton.setDisable(false);
            consoleCheckBox.setDisable(true);
            computerCheckBox.setDisable(true);
            digitalCheckBox.setDisable(true);
            phoneCheckBox.setDisable(true);
        } else {
            setADButton.setDisable(true);
            consoleCheckBox.setDisable(false);
            computerCheckBox.setDisable(false);
            digitalCheckBox.setDisable(false);
            phoneCheckBox.setDisable(false);
        }
    }

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
    void computer(ActionEvent event) {
        if (computerCheckBox.isSelected()){
            setADButton.setDisable(false);
            consoleCheckBox.setDisable(true);
            digitalCheckBox.setDisable(true);
            accessoriesCheckBox.setDisable(true);
            phoneCheckBox.setDisable(true);
            ramPC.setDisable(false);
            graphic.setDisable(false);
            os.setDisable(false);
            ramPCText.setDisable(false);
            graphicText.setDisable(false);
            osText.setDisable(false);
        } else {
            setADButton.setDisable(true);
            consoleCheckBox.setDisable(false);
            digitalCheckBox.setDisable(false);
            accessoriesCheckBox.setDisable(false);
            phoneCheckBox.setDisable(false);
            ramPC.setDisable(true);
            graphic.setDisable(true);
            os.setDisable(true);
            ramPCText.setDisable(true);
            graphicText.setDisable(true);
            osText.setDisable(true);
        }
    }

    @FXML
    void console(ActionEvent event) {
        if (consoleCheckBox.isSelected()){
            setADButton.setDisable(false);
            digitalCheckBox.setDisable(true);
            computerCheckBox.setDisable(true);
            accessoriesCheckBox.setDisable(true);
            phoneCheckBox.setDisable(true);
            memoryConsole.setDisable(false);
            memoryConsoleText.setDisable(false);
            controller.setDisable(false);
            controllerText.setDisable(false);

        } else {
            setADButton.setDisable(true);
            digitalCheckBox.setDisable(false);
            computerCheckBox.setDisable(false);
            accessoriesCheckBox.setDisable(false);
            phoneCheckBox.setDisable(false);
            memoryConsole.setDisable(true);
            memoryConsoleText.setDisable(true);
            controller.setDisable(true);
            controllerText.setDisable(true);
        }
    }

    @FXML
    void digital(ActionEvent event) {
        if (digitalCheckBox.isSelected()){
            setADButton.setDisable(false);
            consoleCheckBox.setDisable(true);
            computerCheckBox.setDisable(true);
            accessoriesCheckBox.setDisable(true);
            phoneCheckBox.setDisable(true);
        } else {
            setADButton.setDisable(true);
            consoleCheckBox.setDisable(false);
            computerCheckBox.setDisable(false);
            accessoriesCheckBox.setDisable(false);
            phoneCheckBox.setDisable(false);
        }
    }

    @FXML
    void phone(ActionEvent event) {
        if (phoneCheckBox.isSelected()){
            setADButton.setDisable(false);
            consoleCheckBox.setDisable(true);
            computerCheckBox.setDisable(true);
            accessoriesCheckBox.setDisable(true);
            digitalCheckBox.setDisable(true);
            color.setDisable(false);
            colorText.setDisable(false);
            ramPhone.setDisable(false);
            ramPhoneText.setDisable(false);
            memoryPhone.setDisable(false);
            memoryPhoneText.setDisable(false);
            SIM.setDisable(false);
            SIMText.setDisable(false);
        } else {
            setADButton.setDisable(true);
            consoleCheckBox.setDisable(false);
            computerCheckBox.setDisable(false);
            accessoriesCheckBox.setDisable(false);
            digitalCheckBox.setDisable(false);
            color.setDisable(true);
            colorText.setDisable(true);
            ramPhone.setDisable(true);
            ramPhoneText.setDisable(true);
            memoryPhone.setDisable(true);
            memoryPhoneText.setDisable(true);
            SIM.setDisable(true);
            SIMText.setDisable(true);
        }
    }

    @FXML
    void setAD(ActionEvent event) throws IOException {
        boolean isNew = false;

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        AccountHandler accountHandler = new AccountHandler();
        int ownerID = accountHandler.getAccount().getDatabaseID();

        if (newCheckBox.isSelected())
        {
            isNew = true;
        }

        if (digitalCheckBox.isSelected())
        {
            AD ad = new DigitalAppliances(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
            , descriptionTextfield.getText(), ownerID, isNew, brandTextField.getText());

            String dataToServer = new JsonHandler().postNewAd(ad, "digitalAppliances");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }

        else if (accessoriesCheckBox.isSelected())
        {
            AD ad = new DigitalAccessories(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
                    , descriptionTextfield.getText(), ownerID, isNew, brandTextField.getText());

            String dataToServer = new JsonHandler().postNewAd(ad, "digitalAccessories");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }

        else if (computerCheckBox.isSelected())
        {
            AD ad = new Computer(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
                    , descriptionTextfield.getText(), isNew, brandTextField.getText(), Integer.parseInt(ramPCText.getText()),
                    Integer.parseInt(graphicText.getText()), osText.getText(),
                    ownerID);

            String dataToServer = new JsonHandler().postNewAd(ad, "computer");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }


        else if (consoleCheckBox.isSelected())
        {
            AD ad = new GamingConsole(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
                    , descriptionTextfield.getText(), isNew, brandTextField.getText(), Integer.parseInt(memoryConsoleText.getText()),
                    Integer.parseInt(controllerText.getText()),
                    ownerID);

            String dataToServer = new JsonHandler().postNewAd(ad, "gamingConsoles");

            output.write(dataToServer);
            output.newLine();
            output.flush();

        }

        else if (phoneCheckBox.isSelected())
        {
            AD ad = new PhoneAndTablet(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
                    , descriptionTextfield.getText(), ownerID, isNew, brandTextField.getText(), colorText.getText(),
                    Integer.parseInt(ramPhoneText.getText()), Integer.parseInt(memoryPhoneText.getText()),
                    Integer.parseInt(SIMText.getText()));

            String dataToServer = new JsonHandler().postNewAd(ad, "phoneAndTablet");

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
        PageController.open("CreateADDigitalGoodsLight");
    }

}
