package spring.infoSystem.model;

import java.util.ArrayList;
import java.util.List;

public class BarCard {

    String nameDrink;
    String categoryDrink;
    double fortressDrink;
    double sizeDrink;
    double priceDrink;
    List<DishInfo> dishInfoList;

    public BarCard(String nameDrink, String categoryDrink, double fortressDrink, double sizeDrink, double priceDrink) {
        this.nameDrink = nameDrink;
        this.categoryDrink = categoryDrink;
        this.fortressDrink = fortressDrink;
        this.sizeDrink = sizeDrink;
        this.priceDrink = priceDrink;
        this.dishInfoList = new ArrayList<>();
    }

    public BarCard() {
        this.dishInfoList = new ArrayList<>();
    }

    public BarCard(String categoryDrink){
        this.categoryDrink = categoryDrink;
        this.dishInfoList = new ArrayList<>();
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public String getCategoryDrink() {
        return categoryDrink;
    }

    public void setCategoryDrink(String categoryDrink) {
        this.categoryDrink = categoryDrink;
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

    public List<DishInfo> getDishInfos(){
        return dishInfoList;
    }

    public void addDrinkInfoByMenu(DishInfo dish){
        dishInfoList.add(dish);
    }
}
