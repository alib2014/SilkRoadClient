package ADS.RealEstate;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;


public class Building extends RealEstate{

    private int yearOfBuild;
    private String mortgage;
    private String     rent;
    private boolean isStore; // if it is true it is a house else it is a store.

    public Building(String price, String title, String city,
                    String description, int ownerID, Date time, double area) {
        super(price,title, city, description, ownerID, time, area);
    }

    public Building(String price, String title, String city,
                    String description, int ownerID, Date time,
                    double area, int year, String mortgage, String rent, boolean isStore) {
        super(price,title, city, description, ownerID, time, area);
        this.yearOfBuild = year;
        this.mortgage = mortgage;
        this.rent = rent;
        this.isStore = isStore;
    }

    public Building(String price, String title, String city,
                    String description, int ownerID,
                    double area, int year, String mortgage, String rent, boolean isStore) {
        super(price,title, city, description, ownerID, area);
        this.yearOfBuild = year;
        this.mortgage = mortgage;
        this.rent = rent;
        this.isStore = isStore;
    }

    public Building(String price, String title, String city, String description, int ownerID, double area, int yearOfBuild, boolean isStore) {
        super(price, title, city, description, ownerID, area);
        this.yearOfBuild = yearOfBuild;
        this.isStore = isStore;
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }

    public String getMortgage() {
        return mortgage;
    }

    public String getRent() {
        return rent;
    }

    public boolean isStore() {
        return isStore;
    }
}
