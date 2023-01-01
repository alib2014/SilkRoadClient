package ADS.DigitalGoods;

import ADS.AD;

import java.util.Date;

public abstract class DigitalGoods extends AD {

    private boolean isNew;
    private String  brand;

    public DigitalGoods(String price, String title,
                        String city, String description, int ownerID, Date time, boolean isNew,
                        String brand) {
        super(price, title, city, description, time, ownerID);
        this.isNew = isNew;
        this.brand = brand;
    }

    public DigitalGoods(String price, String title,
                        String city, String description, int ownerID, boolean isNew, String brand) {
        super(price, title, city, description, ownerID);
        this.isNew = isNew;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isNew() {
        return isNew;
    }
}
