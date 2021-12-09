package spring.infoSystem.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Restaurant {

    private String nameCategory;
    private List<Menu> dishes;
    private List<BarCard> barCards;

    public Restaurant() {
        this.dishes = new ArrayList<>();
        this.barCards = new ArrayList<>();
    }

    public Restaurant(String nameCategory) {
        this.nameCategory = nameCategory;
        this.dishes = new ArrayList<>();
        this.barCards = new ArrayList<>();
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Menu> getDishes(){
        return dishes;
    }

    public List<BarCard> getBarCards(){
        return barCards;
    }

    public void addMenuToCategory(Menu menu){
        dishes.add(menu);
    }

    public void addDrinkToCategory(BarCard drink){
        barCards.add(drink);
    }

}