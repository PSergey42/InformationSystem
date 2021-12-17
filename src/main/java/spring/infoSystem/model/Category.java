package spring.infoSystem.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable {

    private String typeMenu;
    private String nameCategory;
    private List<Drink> barCards;
    private List<Dish> dishList;

    public Category() {
        this.dishList = new ArrayList<>();
        this.barCards = new ArrayList<>();
    }

    public Category(String typeMenu, String nameCategory) {
        this.typeMenu = typeMenu;
        this.nameCategory = nameCategory;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public Category(String typeMenu){
        this.typeMenu = typeMenu;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public List<Drink> getBarCards(){
        return barCards;
    }

    public List<Dish> getDishList(){
        return dishList;
    }

    public void addDishToCategory(Dish dish){
        dishList.add(dish);
    }

    public void addDrinkToCategory(Drink drink){
        barCards.add(drink);
    }

}