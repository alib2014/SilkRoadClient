package com.example.silkroad;

import ADS.AD;
import ADS.PersonalItems.PersonalItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class CreateADPersonalItemsLightController {

    @FXML
    private ImageView ADImage;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField descriptionTextfield;

    @FXML
    private CheckBox newCheckBox;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField titleTextField;
    private File file = null;

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

        boolean isNew = false;
        if (newCheckBox.isSelected())
        {
            isNew = true;
        }

        AccountHandler accountHandler = new AccountHandler();
        int ownerID = accountHandler.getAccount().getDatabaseID();

        AD ad = new PersonalItems(priceTextField.getText(), titleTextField.getText(), cityTextField.getText(),
                descriptionTextfield.getText(), ownerID, isNew);

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().postNewAd(ad, "personalItem");

        output.write(dataToServer);
        output.newLine();
        output.flush();

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int id = Integer.parseInt(input.readLine());

        if (file != null) {
            dataToServer = new JsonHandler().saveAdPicture(id);
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
        PageController.open("CreateADPersonalItemsDark");
    }

}
