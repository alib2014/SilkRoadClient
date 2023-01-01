package com.example.silkroad;

import ADS.AD;
import ADS.Appliances.Appliances;
import ADS.DigitalGoods.*;
import ADS.IndustrialEquipment.IndustrialEquipment;
import ADS.PersonalItems.PersonalItems;
import ADS.RealEstate.Building;
import ADS.RealEstate.Land;
import ADS.Vehicle.Bike;
import ADS.Vehicle.Car;
import ADS.Vehicle.Motorcycle;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AdsNumberHandler
{
    public static int accStart = 0;
    public static int acccEnd = 5;
    public static int start = 0;
    public static int end = 8;
    public static int totalSize = 0;
    public static int pageCounter = 0;
    public static int totalAccSize = 0;
    public static List<AD> ADsToShow = new ArrayList<>();
    public static List<Account> accounts = new ArrayList<>();
    public static List<AD> suggestedADs = new ArrayList<>();
    public static PhoneAndTablet phoneAndTablet;
    public static PersonalItems personalItems;
    public static Motorcycle motorcycle;
    public static Land land;
    public static IndustrialEquipment industrialEquipment;
    public static GamingConsole gamingConsole;
    public static DigitalAccessories digitalAccessories;
    public static DigitalAppliances digitalAppliances;
    public static Computer computer;
    public static Car car;
    public static Building building;
    public static Bike bike;
    public static Appliances appliances;
    public static JSONObject filter;
    public static String category;

    public static void increase () {
        start += 8;
    }

    public static void decrease () {
        start -= 8;
    }

    public static void accIncrease (){
        accStart += 5;
    }

    public static void accDecrease (){
        acccEnd -= 5;
    }

    public static void getAds () throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String temp = input.readLine();
        int size = Integer.parseInt(temp);

        for (int i = 0; i < size; i++) {
            String ad = input.readLine();
            AD newAd = new Gson().fromJson(ad, AD.class);
            ADsToShow.add(newAd);
        }

        for (int i = size; i < 8; i++) {
            ADsToShow.add(null);
        }
    }

    public static void getsearchedAds () throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String temp = input.readLine();
        int size = Integer.parseInt(temp);
        System.out.println(size);

        for (int i = 0; i < size; i++)
        {
            String ad = input.readLine();
            AD newAd = new Gson().fromJson(ad, AD.class);
            ADsToShow.add(newAd);
        }

        for (int i = size; i < 8; i++) {
            ADsToShow.add(null);
        }
    }

    public static void getSpecificAd(int adNumber) throws IOException {
        int adID = AdsNumberHandler.ADsToShow.get(adNumber).getDatabaseID();
        String dataToServer = new JsonHandler().getSpecificAd(adID);

        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        output.write(dataToServer);
        output.newLine();
        output.flush();

        category = input.readLine();

        switch (category) {
            case "Appliance": {
                Gson gson = new Gson();
                String ad = input.readLine();
                appliances = gson.fromJson(ad, Appliances.class);
                break;
            }
            case "Computer" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                computer = gson.fromJson(ad, Computer.class);
                break;
            }
            case "DigitalAccessories": {
                Gson gson = new Gson();
                String ad = input.readLine();
                digitalAccessories = gson.fromJson(ad, DigitalAccessories.class);
                break;
            }
            case "DigitalAppliance": {
                Gson gson = new Gson();
                String ad = input.readLine();
                digitalAppliances = gson.fromJson(ad, DigitalAppliances.class);
                break;
            }
            case "GamingConsole": {
                Gson gson = new Gson();
                String ad = input.readLine();
                gamingConsole = gson.fromJson(ad, GamingConsole.class);
                break;
            }
            case "PhoneAndTablet": {
                Gson gson = new Gson();
                String ad = input.readLine();
                phoneAndTablet = gson.fromJson(ad, PhoneAndTablet.class);
                break;
            }
            case "IndustrialEquipment": {
                Gson gson = new Gson();
                String ad = input.readLine();
                industrialEquipment = gson.fromJson(ad, IndustrialEquipment.class);
                break;
            }
            case "PersonalItem": {
                Gson gson = new Gson();
                String ad = input.readLine();
                personalItems = gson.fromJson(ad, PersonalItems.class);
                break;
            }
            case "Building" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                building = gson.fromJson(ad, Building.class);
                break;
            }
            case "Land" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                land = gson.fromJson(ad, Land.class);
                break;
            }
            case "Bike" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                bike = gson.fromJson(ad, Bike.class);
                break;
            }
            case "Car" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                car = gson.fromJson(ad, Car.class);
                break;
            }
            case "Motorcycle" : {
                Gson gson = new Gson();
                String ad = input.readLine();
                motorcycle = gson.fromJson(ad, Motorcycle.class);
                break;
            }
        }
    }

    public static AD func(String ad, Class tClass) {
        AD Ad = (AD) new Gson().fromJson(ad, tClass);
        return Ad;
    }

    public static void addToHistory (int adID, int accID) throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().addADToHistory(adID, accID);

        output.write(dataToServer);
        output.newLine();
        output.flush();
    }

    public static void add_delete_bookmark (int adID, int accID) throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String dataToServer = new JsonHandler().add_delete_bookmark(adID, accID);

        output.write(dataToServer);
        output.newLine();
        output.flush();
    }

    public static void getContacts (int accID) throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String dataToSServer = new JsonHandler().getContacts(accID);

        output.write(dataToSServer);
        output.newLine();
        output.flush();

        totalAccSize = Integer.parseInt(input.readLine());

        String temp = input.readLine();
        int size = Integer.parseInt(temp);

        for (int i = 0; i < size; i++)
        {
            String acc = input.readLine();
            Account account = new Gson().fromJson(acc, Account.class);

            accounts.add(account);
        }

        for (int i = 0; i < 5; i++)
        {
            accounts.add(null);
        }
    }

    public static void getSuggestion (int accID) throws IOException {
        CreateSocket createSocket = new CreateSocket();
        Socket socket = createSocket.getSocket();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String dataToServer = new JsonHandler().getSuggestion(accID);

        output.write(dataToServer);
        output.newLine();
        output.flush();

        String temp = input.readLine();
        int size = Integer.parseInt(temp);

        for (int i = 0; i < size; i++)
        {
            String ad = input.readLine();
            AD newAd = new Gson().fromJson(ad, AD.class);
            suggestedADs.add(newAd);
        }

        for (int i = size; i < 5; i++)
        {
            suggestedADs.add(null);
        }
    }
}
