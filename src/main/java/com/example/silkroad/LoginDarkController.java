package com.example.silkroad;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginDarkController implements Initializable {

    @FXML
    private Label captchaValid;

    @FXML
    private Label error;

    @FXML
    private Label captchaLabel;

    @FXML
    private TextField captchaTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    @FXML
    void forgetPass(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("PasswordRecoveryDark");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuDark");
    }

    @FXML
    void Login(ActionEvent event) throws IOException {
        captchaValid.setText("");
        error.setText("");

        String captcha = captchaTextField.getText();

        if (captcha.equals(captchaLabel.getText())){
            CreateSocket createSocket = new CreateSocket();
            Socket socket = createSocket.getSocket();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String dataToServer = new JsonHandler().login(usernameTextField.getText()
                    , passwordTextField.getText());

            output.write(dataToServer);
            output.newLine();
            output.flush();

            boolean isAccountFound =  Boolean.parseBoolean(input.readLine());
            if (isAccountFound) {
                //System.out.println("Welcome!");
                JsonHandler jsonHandler = new JsonHandler();
                // sending username and request for get all information of account.
                dataToServer = jsonHandler.getMyAccount(usernameTextField.getText());
                output.write(dataToServer);
                output.newLine();
                output.flush();

                String data = input.readLine();
                System.out.println(data);
                Gson gson = new Gson();
                Account account = gson.fromJson(data, Account.class);
                AccountHandler accountHandler = new AccountHandler(account, socket);
                // finish here

                // changing online status true
                output.write(new JsonHandler().changeOnlineStatus(account.getDatabaseID(), true));
                output.newLine();
                output.flush();

                PageController.close();
                PageController.open("ProfileDark");

            } else {
                error.setText("USER AND PASS DO NOT MATCH!");
            }
        } else {
            captchaValid.setText("Wrong captcha!");
        }
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SignUpDark");
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("LoginLight");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        captchaLabel.setText(new MakeRandomCaptcha().getRandomCaptcha());
    }
}

