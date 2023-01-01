package ADS.PersonalItems;

import ADS.AD;
import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class PersonalItems extends AD {

    private boolean isNew;

    public PersonalItems(String price, String title,
                         String city, String description, int ownerID, boolean isNew) {
        super(price,title, city, description, ownerID);
        this.isNew = isNew;
    }

    public PersonalItems(String price, String title,
                         String city, String description, int ownerID, Date time, boolean isNew) {
        super(price,title, city, description, time, ownerID);
        this.isNew = isNew;
    }

    public boolean isNew() {
        return isNew;
    }
}
