package com.example.silkroad;

import ADS.Appliances.Appliances;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class CreateADAppliancesLightController {

    @FXML
    private ImageView ADImage;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField colorTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private CheckBox newCheckBox;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField titleTextField;

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

    private File file = null;

    @FXML
    void setAD(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        boolean isNew = false;
        if (newCheckBox.isSelected())
        {
            isNew = true;
        }

        Appliances ad = new Appliances(priceTextField.getText(), titleTextField.getText(), cityTextField.getText()
                , descriptionTextField.getText(), accountHandler.getAccount().getDatabaseID(), isNew, colorTextField.getText());
        JSONObject jsonObject = new JSONObject(ad);

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String dataToServer = new JsonHandler().postNewAd(ad, "appliances");

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
        PageController.open("CreateADAppliancesDark");
    }

}
