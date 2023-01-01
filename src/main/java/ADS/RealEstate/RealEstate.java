package ADS.RealEstate;

import ADS.AD;
import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public abstract class RealEstate extends AD {

    private double area;

    public RealEstate(String price,String title, String city, String description, int ownerID, double area) {
        super(price, title, city, description, ownerID);
        this.area = area;
    }

    public RealEstate(String price, String title, String city,
                      String description, int ownerID, Date time, double area) {
        super(price,title, city, description, time, ownerID);
        this.area = area;
    }

    public double getArea() {
        return area;
    }
}
