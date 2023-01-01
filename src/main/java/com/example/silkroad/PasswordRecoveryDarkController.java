package com.example.silkroad;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRecoveryDarkController {

    @FXML
    private Button check;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button sendCode;

    @FXML
    private Label emailVerify;

    private String code;

    @FXML
    void emailType(KeyEvent event) {

        emailTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                Pattern emailPat = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@']+(\\.[^<>()\\[\\]\\\\.,;:\\s@']+)*)|" +
                        "('.+'))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|" +
                        "(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                Matcher emailMat = emailPat.matcher(emailTextField.getText());
                if (emailMat.find()) {
                    emailVerify.setText("Acceptable");
                    emailVerify.setTextFill(Color.GREEN);
                } else {
                    emailVerify.setText("Not Acceptable");
                    emailVerify.setTextFill(Color.RED);
                }
            }
        });

    }

    @FXML
    void sendCode(ActionEvent event) throws IOException {
        String email = emailTextField.getText();
        BufferedWriter output = new CreateSocket().getOutput();
        output.write(new JsonHandler().passwordRecovery(email));
        output.newLine();
        output.flush();

        BufferedReader input = new CreateSocket().getInput();
        code = input.readLine();
    }

    @FXML
    void check(ActionEvent event) throws IOException {
        if (code.equals(codeTextField.getText())) {
            BufferedWriter output = new CreateSocket().getOutput();
            BufferedReader input = new CreateSocket().getInput();
            output.write(new JsonHandler().getMyAccountByEmail(emailTextField.getText()));
            output.newLine();
            output.flush();

            String data = input.readLine();
            System.out.println(data);
            Gson gson = new Gson();
            Account account = gson.fromJson(data, Account.class);
            AccountHandler accountHandler = new AccountHandler(account, new CreateSocket().getSocket());
            PageController.close();
            PageController.open("EditInfoDark");
        }
    }

}
