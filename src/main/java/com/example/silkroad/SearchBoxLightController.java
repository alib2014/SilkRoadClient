package com.example.silkroad;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchBoxLightController {

    @FXML
    private CheckBox appliances;

    @FXML
    private TextField city;

    @FXML
    private TextField minPrice;

    @FXML
    private TextField maxPrice;

    @FXML
    private CheckBox digital;

    @FXML
    private CheckBox industrial;

    @FXML
    private CheckBox personal;

    @FXML
    private CheckBox realState;

    @FXML
    private TextField title;

    @FXML
    private CheckBox vehicle;

    @FXML
    void search(ActionEvent event) throws IOException {
        JSONObject filter = new JSONObject();
        List<String> categoryFilter = new ArrayList<>();

        if (appliances.isSelected())
        {
            categoryFilter.add("Appliances");
        }
        if (digital.isSelected())
        {
            categoryFilter.add("GamingConsole");
            categoryFilter.add("PhonesAndTablets");
            categoryFilter.add("Computers");
            categoryFilter.add("DigitalAccessories");
        }
        if (industrial.isSelected())
        {
            categoryFilter.add("IndustrialEquipments");
        }
        if (personal.isSelected())
        {
            categoryFilter.add("PersonalItems");
        }
        if (realState.isSelected())
        {
            categoryFilter.add("BuildingsForRent");
            categoryFilter.add("BuildingsForSale");
            categoryFilter.add("Lands");
        }
        if (vehicle.isSelected())
        {
            categoryFilter.add("Car");
            categoryFilter.add("Bike");
            categoryFilter.add("Motorcycle");
        }

        filter.put("category", categoryFilter);

        if (!city.getText().isEmpty())
        {
            filter.put("city", city.getText());
        }
        if (!title.getText().isEmpty())
        {
            filter.put("title", title.getText());
        }
        if (!minPrice.getText().isEmpty() && !maxPrice.getText().isEmpty())
        {
            filter.put("upperBound", maxPrice.getText());
            filter.put("lowerBound", minPrice.getText());
        }

        AdsNumberHandler.filter = filter;

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader inpuut = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String dataToServer = new JsonHandler().search(AdsNumberHandler.filter);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        AdsNumberHandler.totalSize = Integer.parseInt(inpuut.readLine());

        AdsNumberHandler.getsearchedAds();

        PageController.close();
        PageController.open("ShowSearchesLight");
    }

    @FXML
    void switchDark(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SearchBoxDark");
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

}
