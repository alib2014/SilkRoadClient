package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuLightController {

    @FXML
    void guest(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("GuestLight");
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("LoginLight");
    }

    @FXML
    void quit(ActionEvent event) {
        PageController.close();
        System.exit(0);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SignUpLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuDark");
    }

}
