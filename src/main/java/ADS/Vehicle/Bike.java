package ADS.Vehicle;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class Bike extends Vehicle {

    private int size;

    public Bike(String price, String title, String city,
                String description, int ownerID, Date time, String brand) {
        super(price, title, city, description, ownerID, time, brand);
    }

    public Bike(String price, String title, String city,
                String description, int ownerID, Date time,  String brand, int size) {
        super(price, title, city, description, ownerID, time, brand);
        this.size = size;
    }

    public Bike(String price, String title, String city,
                String description, int ownerID, String brand, int size) {
        super(price, title, city, description, ownerID, brand);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
