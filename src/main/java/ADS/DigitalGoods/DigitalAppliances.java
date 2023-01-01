package ADS.DigitalGoods;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class DigitalAppliances extends DigitalGoods{

    public DigitalAppliances(String price, String title, String city,
                             String description, int ownerID, Date time, boolean isNew, String brand) {
        super(price, title, city, description, ownerID, time, isNew, brand);
    }

    public DigitalAppliances(String price, String title, String city, String description, int ownerID, boolean isNew, String brand) {
        super(price, title, city, description, ownerID, isNew, brand);
    }
}
