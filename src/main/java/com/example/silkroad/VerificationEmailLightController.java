package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class VerificationEmailLightController {
    @FXML
    private TextField verificationEmailTextField;


    @FXML
    void backMenu(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void check(ActionEvent event) throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String enteredCode = verificationEmailTextField.getText();
        String dataToServer = new JsonHandler().checkEmailVerificationCode(enteredCode);
        try {
            output.write(dataToServer);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            boolean isValid = Boolean.parseBoolean(input.readLine());
            if (isValid) {
                AccountHandler accountHandler = new AccountHandler();
                Account account = accountHandler.getAccount();
                String jsonInString = new JsonHandler().jsonAccountInString(account, "finalSignUpAccount");
                try {
                    output.write(jsonInString);
                    output.newLine();
                    output.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println("trying to get true...");
                    boolean isRegisterSuccessful = Boolean.parseBoolean(input.readLine());
                    System.out.println("Register: " + isRegisterSuccessful);
                    if (isRegisterSuccessful) {
                        System.out.println("You registered Successfully");
                        PageController.close();
                        PageController.open("ProfileLight");
                    } else {
                        System.out.println("Error");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SignUPLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("VerificationEmailDark");
    }

}
