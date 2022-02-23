package spring.infoSystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Drink implements CheckIn{

    private int id;
    @NotEmpty(message = "Name should not be empty")
    String nameDrink;
    //String nameCategory;
    @Min(value = 0, message = "Error")
    double fortressDrink;
    @Min(value = 0, message = "Error")
    double sizeDrink;
    @Min(value = 0, message = "Error")
    double priceDrink;
    int category_id;

    public Drink(String nameDrink, double fortressDrink, double sizeDrink, double priceDrink) {
        this.nameDrink = nameDrink;
        this.fortressDrink = fortressDrink;
        this.sizeDrink = sizeDrink;
        this.priceDrink = priceDrink;
    }

    public Drink(){}


    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public double getFortressDrink() {
        return fortressDrink;
    }

    public void setFortressDrink(double fortressDrink) {
        this.fortressDrink = fortressDrink;
    }

    public double getSizeDrink() {
        return sizeDrink;
    }

    public void setSizeDrink(double sizeDrink) {
        this.sizeDrink = sizeDrink;
    }

    public double getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(double priceDrink) {
        this.priceDrink = priceDrink;
    }
}