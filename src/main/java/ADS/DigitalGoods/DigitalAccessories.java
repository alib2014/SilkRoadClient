package ADS.DigitalGoods;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class DigitalAccessories extends DigitalGoods{

    public DigitalAccessories(String price, String title, String city,
                              String description, Date time, boolean isNew, String brand, int ownerID) {
        super(price, title, city, description, ownerID, time, isNew, brand);
    }

    public DigitalAccessories(String price, String title, String city, String description, int ownerID, boolean isNew, String brand) {
        super(price, title, city, description, ownerID, isNew, brand);
    }


}
