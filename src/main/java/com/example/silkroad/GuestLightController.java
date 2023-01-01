package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GuestLightController {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;

    @FXML
    private Pane pane6;

    @FXML
    private Pane pane7;

    @FXML
    private Pane pane8;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label price3;

    @FXML
    private Label price4;

    @FXML
    private Label price5;

    @FXML
    private Label price6;

    @FXML
    private Label price7;

    @FXML
    private Label price8;

    @FXML
    private Label title1;

    @FXML
    private Label title2;

    @FXML
    private Label title3;

    @FXML
    private Label title4;

    @FXML
    private Label title5;

    @FXML
    private Label title6;

    @FXML
    private Label title7;

    @FXML
    private Label title8;

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("GuestDark");
    }

    @FXML
    void lastPage(ActionEvent event) throws IOException {

    }

    @FXML
    void nextPage(ActionEvent event) throws IOException {

    }

    @FXML
    void openAD1(MouseEvent event) {

    }

    @FXML
    void openAD2(MouseEvent event) {

    }

    @FXML
    void openAD3(MouseEvent event) {

    }

    @FXML
    void openAD4(MouseEvent event) {

    }

    @FXML
    void openAD5(MouseEvent event) {

    }

    @FXML
    void openAD6(MouseEvent event) {

    }

    @FXML
    void openAD7(MouseEvent event) {

    }

    @FXML
    void openAD8(MouseEvent event) {

    }

}

