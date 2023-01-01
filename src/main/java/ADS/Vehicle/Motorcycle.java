package ADS.Vehicle;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class Motorcycle extends Vehicle{

    private int   kilometer;
    private int yearOfBuild;


    public Motorcycle(String price, String title, String city,
                      String description, int ownerID, Date time,
                      int yearOfBuild, String brand, int kilometer) {
        super(price, title, city, description, ownerID, time, brand);
        this.kilometer = kilometer;
        this.yearOfBuild = yearOfBuild;
    }

    public Motorcycle(String price, String title, String city,
                      String description, int ownerID,
                      int yearOfBuild, String brand, int kilometer) {
        super(price, title, city, description, ownerID, brand);
        this.kilometer = kilometer;
        this.yearOfBuild = yearOfBuild;
    }

    public int getKilometer() {
        return kilometer;
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }
}
