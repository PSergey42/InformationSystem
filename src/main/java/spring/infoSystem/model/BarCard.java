package spring.infoSystem.model;

import java.util.ArrayList;
import java.util.List;

public class BarCard {

    String nameDrink;
    String nameCategory;
    double fortressDrink;
    double sizeDrink;
    double priceDrink;

    public BarCard(String nameDrink, String nameCategory, double fortressDrink, double sizeDrink, double priceDrink) {
        this.nameDrink = nameDrink;
        this.nameCategory = nameCategory;
        this.fortressDrink = fortressDrink;
        this.sizeDrink = sizeDrink;
        this.priceDrink = priceDrink;
    }

    public BarCard(){}

    public BarCard(String nameCategory){
        this.nameCategory = nameCategory;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
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
