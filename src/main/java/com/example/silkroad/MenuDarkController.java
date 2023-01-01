package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MenuDarkController {

    @FXML
    void guest(ActionEvent event) throws IOException {

        JSONObject filter = new JSONObject();
        List<String> categoryFilter = new ArrayList<>();

        filter.put("category", categoryFilter);

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
        PageController.open("GuestDark");
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("LoginDark");
    }

    @FXML
    void quit(ActionEvent event) {
        PageController.close();
        System.exit(0);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SignUpDark");
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("MenuLight");
    }

}
