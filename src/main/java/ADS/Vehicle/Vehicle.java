package ADS.Vehicle;

import ADS.AD;
import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public abstract class Vehicle extends AD {
    private String brand;

    public Vehicle(String price, String title,
                   String city, String description, int ownerID) {
        super(price, title, city, description, ownerID);
    }

    public Vehicle(String price, String title, String city,
                   String description, int ownerID, Date time, String brand) {
        super(price, title, city, description, time, ownerID);
        this.brand = brand;
    }

    public Vehicle(String price, String title, String city,
                   String description, int ownerID, String brand) {
        super(price, title, city, description, ownerID);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
