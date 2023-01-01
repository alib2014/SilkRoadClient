package ADS.DigitalGoods;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class PhoneAndTablet extends DigitalGoods{

    private String         color;
    private int              RAM;
    private int           memory;
    private int numberOfSIMCards;


    public PhoneAndTablet(String price, String title, String city,
                          String description, Date time, boolean isNew, String brand, int ownerID) {
        super(price, title, city, description, ownerID, time, isNew, brand);
    }

    public PhoneAndTablet(String price, String title, String city,
                          String description, int ownerID,
                          boolean isNew, String brand, String color, int ram, int memory, int numberOfSIMCard) {
        super(price, title, city, description, ownerID, isNew, brand);
        this.color = color;
        this.RAM = ram;
        this.memory = memory;
        this.numberOfSIMCards = numberOfSIMCard;
    }

    public String getColor() {
        return color;
    }

    public int getRAM() {
        return RAM;
    }

    public int getMemory() {
        return memory;
    }

    public int getNumberOfSIMCards() {
        return numberOfSIMCards;
    }
}
