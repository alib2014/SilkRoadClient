package com.example.silkroad;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpLightController implements Initializable {

    @FXML
    private Label captchaLabel;

    @FXML
    private TextField captchaTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField eMailTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label passPower;

    @FXML
    private Label phoneVerify;

    @FXML
    private Label emailVerify;

    @FXML
    private Label cityValid;

    @FXML
    private Label notAcceptable;

    @FXML
    void typePass(KeyEvent event) {

        passwordTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                Pattern pattern = Pattern.compile("^(?=(.*[a-z]){3,})(?=(.*[A-Z]){2,})(?=(.*[0-9]){2,})(?=(." +
                        "*[!@#$%^&*()\\-_+.])+).{8,}$");
                Matcher matcher = pattern.matcher(passwordTextField.getText());
                if (matcher.find()) {
                    passPower.setText("Powerful");
                    passPower.setTextFill(Color.GREEN);
                } else {
                    passPower.setText("Weak");
                    passPower.setTextFill(Color.RED);
                }
            }
        });

    }

    @FXML
    void typePhone(KeyEvent event) {

        phoneNumberTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                Pattern phonePat = Pattern.compile("^(09)\\d{9}\\b");
                Matcher matcher = phonePat.matcher(phoneNumberTextField.getText());
                if (matcher.find()) {
                    phoneVerify.setText("Acceptable");
                    phoneVerify.setTextFill(Color.GREEN);
                } else {
                    phoneVerify.setText("Not Acceptable");
                    phoneVerify.setTextFill(Color.RED);
                }
            }
        });

    }

    @FXML
    void emailType(KeyEvent event) {

        eMailTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                Pattern emailPat = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@']+(\\.[^<>()\\[\\]\\\\.,;:\\s@']+)*)|" +
                        "('.+'))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|" +
                        "(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                Matcher emailMat = emailPat.matcher(eMailTextField.getText());
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
    void Login(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("LoginLight");
    }

    @FXML
    void signUp(ActionEvent event) throws FileNotFoundException {

        notAcceptable.setText("");
        String name = nameTextField.getText();
        String lastName = lastnameTextField.getText();
        String email = eMailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String city = cityTextField.getText();
        city = city.toLowerCase();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String captcha = captchaTextField.getText();
        boolean isValidCity = false;

        File file = new File("D:\\silkroad\\src\\main\\resources\\EditedPureCities3.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            if (text.equals(city)) {
                isValidCity = true;
            }
        }

        if (!isValidCity){
            cityValid.setText("City not found!");
            cityValid.setTextFill(Color.RED);
        }

        if(emailVerify.getText().equals("Acceptable") && phoneVerify.getText().equals("Acceptable") &&
                passPower.getText().equals("Powerful") && isValidCity && captcha.equals(captchaLabel.getText())){

            try {
                Account account = new Account(name, lastName, email, phoneNumber, city, username, password);
                AccountHandler accountHandler = new AccountHandler(account, new CreateSocket().getSocket());
                boolean isAccountExist = accountHandler.checkSignUpAccount();
                if (!isAccountExist) /* doesn't exist */ {
                    boolean isSent = accountHandler.emailVerificationCodeRequest();
                    System.out.println(isSent);
                    PageController.close();
                    PageController.open("VerificationEmailLight");
                } else {
                    notAcceptable.setText("Your username or Email is already used!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SignUpDark");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        captchaLabel.setText(new MakeRandomCaptcha().getRandomCaptcha());
    }
}
