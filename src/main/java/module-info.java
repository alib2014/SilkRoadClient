module com.example.silkroad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires org.json;

    opens com.example.silkroad to javafx.fxml, com.google.gson;
    opens ADS to javafx.fxml, com.google.gson;
    opens ADS.Appliances to com.google.gson;
    opens ADS.DigitalGoods to com.google.gson;
    opens ADS.IndustrialEquipment to com.google.gson;
    opens ADS.PersonalItems to com.google.gson;
    opens ADS.RealEstate to com.google.gson;
    opens ADS.Vehicle to com.google.gson;
    exports com.example.silkroad;
    exports ADS;
    exports ADS.Appliances;
    exports ADS.Vehicle;
    exports ADS.DigitalGoods;
    exports ADS.IndustrialEquipment;
    exports ADS.PersonalItems;
    exports ADS.RealEstate;
}