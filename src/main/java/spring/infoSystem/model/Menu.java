package spring.infoSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String nameDishes;
    private String nameCategory;
    private double price;
    List<DishInfo> dishInfoList;

    public Menu(String nameDishes, String nameCategory, double price) {
        this.nameDishes = nameDishes;
        this.nameCategory = nameCategory;
        this.price = price;
        this.dishInfoList = new ArrayList<>();
    }

    public Menu(String nameCategory) {
        this.nameCategory = nameCategory;
        this.dishInfoList = new ArrayList<>();
    }
    public Menu() {
        this.dishInfoList = new ArrayList<>();
    }

    public String getNameDish() {
        return nameDishes;
    }

    public void setNameDish(String nameDishes) {
        this.nameDishes = nameDishes;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
         this.price = price;
    }

    public List<DishInfo> getDishInfos(){
        return dishInfoList;
    }

    public void addDishInfoByMenu(DishInfo dish){
        dishInfoList.add(dish);
    }
}
