package ADS.Vehicle;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class Car extends Vehicle{

    private int       kilometer;
    private boolean hasPaintJob;
    private String        color;
    private int     yearOfBuild;

    public Car(String price, String title, String city,
               String description, int ownerID, Date time, String brand) {

        super(price, title, city, description, ownerID, time, brand);
    }

    public Car(String price, String title, String city,
               String description, int ownerID, Date time,
               int yearOfBuild, String color, String brand, int kilometer, boolean hasPaintJob) {
        super(price, title, city, description, ownerID, time, brand);
        this.kilometer = kilometer;
        this.hasPaintJob = hasPaintJob;
        this.color = color;
        this.yearOfBuild = yearOfBuild;
    }

    public Car(String price, String title, String city,
               String description, int ownerID,
               int yearOfBuild, String color, String brand, int kilometer, boolean hasPaintJob) {
        super(price, title, city, description, ownerID, brand);
        this.kilometer = kilometer;
        this.hasPaintJob = hasPaintJob;
        this.color = color;
        this.yearOfBuild = yearOfBuild;
    }

    public int getKilometer() {
        return kilometer;
    }

    public boolean isHasPaintJob() {
        return hasPaintJob;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }
}
