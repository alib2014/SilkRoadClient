package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CreateNewADBasicLightController {

    @FXML
    void appliances(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADAppliancesLight");
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

    @FXML
    void backProfile(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ProfileLight");
    }

    @FXML
    void digitalGoods(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADDigitalGoodsLight");
    }

    @FXML
    void industrialEquipment(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADIndustrialEquipmentLight");
    }

    @FXML
    void personalItems(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADPersonalItemsLight");
    }

    @FXML
    void realState(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADRealStateBasicLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateNewADBasicDark");
    }

    @FXML
    void vehicle(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateAdVehicleLight");
    }
}
