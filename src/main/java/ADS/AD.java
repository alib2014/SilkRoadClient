package ADS;

import com.example.silkroad.Account;
import javafx.scene.image.Image;

import java.util.Date;

public class AD {

    private String          price;

    //private Image         imageFX;
    private String          title;
    private String           city;
    private String    description;

    //private Account   ownerObject;

    private Date             date;

    private int           ownerID;
    private int        databaseID;

//    public String getPrice() {
//        return price;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getOwnerID() {
//        return ownerID;
//    }
//
//    public int getDatabaseID() {
//        return databaseID;
//    }

    public AD(String price, String title, String city,
              String description, Date time, int ownerID) {
        this.price = price;
//        this.imageFX = image;
        this.title = title;
        this.city = city;
        this.description = description;
//        this.ownerObject = owner;
        this.date = time;
        this.ownerID = ownerID;
//        this.ownerID = this.ownerObject.getDatabaseID();
    }

    public AD(String price, String title, String city, String description, int ownerID) {
        this.price = price;
        this.title = title;
        this.city = city;
        this.description = description;
        this.ownerID = ownerID;
    }

    public String getPrice() {
        return price;
    }

    //public Image getImageFX() {
      //  return imageFX;
    //}

    public String getTitle() {
        return title;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    //public Account getOwnerObject() {
      //  return ownerObject;
    //}

    public Date getDate() {
        return date;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
    }
}
