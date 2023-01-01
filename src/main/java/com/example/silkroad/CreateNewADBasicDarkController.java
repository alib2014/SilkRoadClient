package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CreateNewADBasicDarkController {

    @FXML
    void appliances(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADAppliancesDark");
    }

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
    void digitalGoods(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADDigitalGoodsDark");
    }

    @FXML
    void industrialEquipment(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADIndustrialEquipmentDark");
    }

    @FXML
    void personalItems(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADPersonalItemsDark");
    }

    @FXML
    void realState(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateADRealStateBasicDark");
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateNewADBasicLight");
    }

    @FXML
    void vehicle(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateAdVehicleDark");
    }
}
