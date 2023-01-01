package ADS.DigitalGoods;

import com.example.silkroad.Account;

import java.util.Date;

public class GamingConsole extends DigitalGoods{

    private int memory;
    private int numberOfController;


    public GamingConsole(String price, String title, String city,
                         String description, boolean isNew, String brand,
                         int memory, int numberOfController, int ownerID, Date time) {
        super(price, title, city, description, ownerID, time, isNew, brand);
        this.memory = memory;
        this.numberOfController = numberOfController;
    }

    public GamingConsole(String price, String title, String city,
                         String description,
                         boolean isNew, String brand, int memory, int numberOfController, int ownerID) {
        super(price, title, city, description, ownerID, isNew, brand);
        this.memory = memory;
        this.numberOfController = numberOfController;
    }

    public int getMemory() {
        return memory;
    }

    public int getNumberOfController() {
        return numberOfController;
    }
}
