package ADS.DigitalGoods;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class Computer extends DigitalGoods{

    private int                RAM;
    private int            graphic;
    private String operatingSystem;


    public Computer(String price, String title, String city,
                    String description, Date time, boolean isNew, String brand, int ownerID
                    , int ram, int graphic, String operatingSystem) {
        super(price, title, city, description, ownerID, time, isNew, brand);
        this.RAM = ram;
        this.graphic = graphic;
        this.operatingSystem = operatingSystem;
    }

    public Computer(String price, String title, String city,
                    String description, boolean isNew,
                    String brand, int ram, int graphic, String operationSystem, int ownerID) {
        super(price, title, city, description, ownerID, isNew, brand);
        this.RAM = ram;
        this.graphic = graphic;
        this.operatingSystem = operationSystem;
    }

    public int getRAM() {
        return RAM;
    }

    public int getGraphic() {
        return graphic;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
