package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class EditInfoDarkController {

    @FXML
    private Label error;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameTextField;

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
    void setChange(ActionEvent event) throws IOException {
        String city = cityTextField.getText();
        String lastName = lastnameTextField.getText();
        String name = nameTextField.getText();
        String pass = passwordTextField.getText();
        String username = usernameTextField.getText();

        CreateSocket createSocket = new CreateSocket();
        BufferedWriter output = createSocket.getOutput();
        output.write(new JsonHandler().changeMyData(new AccountHandler().getAccount().getDatabaseID(),
                city, lastName, name, pass, username));
        output.newLine();
        output.flush();

        BufferedReader input = createSocket.getInput();
        boolean isUsernameChanged = Boolean.parseBoolean(input.readLine());

        if (isUsernameChanged) {
            PageController.close();
            PageController.open("ProfileDark");
        } else {
            error.setText("username is already taken");
        }
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("EditInfoLight");
    }

}
