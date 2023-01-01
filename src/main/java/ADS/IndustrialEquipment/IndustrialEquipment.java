package ADS.IndustrialEquipment;

import ADS.AD;
import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class IndustrialEquipment extends AD {

    public IndustrialEquipment(String price, String title, String city, String description, int ownerID, Date time) {
        super(price,title, city, description, time, ownerID);
    }

    public IndustrialEquipment(String price, String title, String city, String description, int ownerID) {
        super(price,title, city, description, ownerID);
    }
}
