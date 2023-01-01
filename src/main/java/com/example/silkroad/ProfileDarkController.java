package com.example.silkroad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.silkroad.CreateSocket.input;
import static com.example.silkroad.CreateSocket.output;

public class ProfileDarkController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(accountHandler.getAccount().getName());
        lastLabel.setText(accountHandler.getAccount().getLastName());
        phoneNumberLabel.setText(accountHandler.getAccount().getPhoneNumber());
        EmailLabel.setText(accountHandler.getAccount().getEmail());
        NotificationHandler notificationHandler = new NotificationHandler();
        notificationHandler.start();
        try {
            getPicture();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized void getPicture() throws IOException {
        System.out.println("48");
        String dataToServer = new JsonHandler().getUserPicture(accountHandler.getAccount().getDatabaseID());
        output.write(dataToServer);
        output.newLine();
        output.flush();
        System.out.println("50");
        String path = ImageHandler.receiveUserImage();
        File file = new File(path);
        Image image = new Image(file.toURL().toString());
        System.out.println("54");
        profileImage.setImage(image);
        System.out.println("56");
    }

    private AccountHandler accountHandler = new AccountHandler();

    @FXML
    private CheckBox phoneShower;

    @FXML
    private Label lastLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private ImageView profileImage;

    @FXML
    void phoneShow(ActionEvent event){
        if (phoneShower.isSelected()){

        } else {

        }
    }

    @FXML
    void chatContact(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        int accID = accountHandler.getAccount().getDatabaseID();

        AdsNumberHandler.getContacts(accID);

        PageController.close();
        PageController.open("ContactsDark");
    }

    @FXML
    void createNewADS(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("CreateNewADBasicDark");
    }

    @FXML
    void goSearchBox(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("SearchBoxDark");
    }

    @FXML
    void setPicture(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose your picture");
        File file = fileChooser.showOpenDialog(stage);


        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        String dataToServer = new JsonHandler().saveUserPicture(accountHandler.getAccount().getDatabaseID());

        output.write(dataToServer);
        output.newLine();
        output.flush();

        ImageHandler imageHandler = new ImageHandler(file, id);

        imageHandler.sendImage();

        Image image = new Image(file.toURL().toString());
        profileImage.setImage(image);
    }

    @FXML
    void backMenu(ActionEvent event) throws IOException {
        AccountHandler.setAccount(null);
        NotificationHandler.getTimeline().stop();
        PageController.close();
        PageController.open("MenuDark");

        AdsNumberHandler.ADsToShow.clear();
    }

    @FXML
    void showBookmarks(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String dataToServer = new JsonHandler().getBookmarks(id);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        String temp = input.readLine();
        AdsNumberHandler.totalSize = Integer.parseInt(temp);

        AdsNumberHandler.getAds();

        PageController.close();
        PageController.open("BookmarksDark");

    }

    @FXML
    void showHistory(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().getHistory(id);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        AdsNumberHandler.getAds();

        PageController.close();
        PageController.open("HistoryDark");
    }

    @FXML
    void showYourADS(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        int id = accountHandler.getAccount().getDatabaseID();

        String dataToServer = new JsonHandler().getMyAds(id);

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        output.write(dataToServer);
        output.newLine();
        output.flush();

        String temp = input.readLine();
        AdsNumberHandler.totalSize = Integer.parseInt(temp);
        AdsNumberHandler.getAds();

        PageController.close();
        PageController.open("YourADsDark");
    }

    @FXML
    void editInfo(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("PasswordVerifyDark");
    }

    @FXML
    void switchLight(ActionEvent event) throws IOException {
        PageController.close();
        PageController.open("ProfileLight");
    }

    public void explore(ActionEvent event) throws IOException {
        AccountHandler accountHandler = new AccountHandler();
        int accID = accountHandler.getAccount().getDatabaseID();

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

        AdsNumberHandler.getSuggestion(accID);

        PageController.close();
        PageController.open("ExploreDark");
    }

}
