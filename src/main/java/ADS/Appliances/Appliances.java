package ADS.Appliances;

import ADS.AD;

public class Appliances extends AD {

    private boolean isNew;
    private String  color;

    public Appliances(String price, String title, String city, String description, int ownerID, boolean isNew, String color) {
        super(price, title, city, description, ownerID);
        this.isNew = isNew;
        this.color = color;
    }

    //    public Appliances(String price, String title, String city, String description, int ownerID, boolean isNew, String color) {
//        super(price, title, city, description, ownerID);
//        this.checkNew = isNew;
//        this.color = color;
//    }

//    public Appliances(String price, String title,
//                      String city, String description) {
//        super(price, title, city, description);
//
//    }
//
//    public Appliances(String price,String title, String city,
//                      String description, boolean isNew, String color) {
//        super(price, title, city, description);
//        this.checkNew = isNew;
//        this.color = color;
//    }

    public String getColor() {
        return color;
    }

    public boolean isNew() {
        return isNew;
    }

}
