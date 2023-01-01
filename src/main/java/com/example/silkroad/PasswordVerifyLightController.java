package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class PasswordVerifyLightController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    void check(ActionEvent event) throws IOException {
        String pass = passwordTextField.getText();
        CreateSocket createSocket = new CreateSocket();
        BufferedWriter output = createSocket.getOutput();
        BufferedReader input = createSocket.getInput();
        output.write(new JsonHandler().checkMyPassword(new AccountHandler().getAccount().getUsername(),
                pass));
        output.newLine();
        output.flush();

        boolean isValidPassword = Boolean.parseBoolean(input.readLine());

        if (isValidPassword){
            PageController.close();
            PageController.open("EditInfoLight");
        }
    }

}
