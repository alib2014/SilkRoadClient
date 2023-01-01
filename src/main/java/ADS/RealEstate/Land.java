package ADS.RealEstate;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class Land extends RealEstate{

    public Land(String price, String title, String city,
                String description, int ownerID, Date time, double area) {
        super(price,title, city, description, ownerID, time, area);
    }

    public Land(String price, String title, String city,
                String description, int ownerID, double area) {
        super(price,title, city, description, ownerID, area);
    }
}
