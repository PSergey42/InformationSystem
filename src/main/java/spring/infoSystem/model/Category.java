package spring.infoSystem.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable {

    private String nameTypeMenu;
    @NotEmpty(message = "Name should not be empty")
    private String nameCategory;
    private List<Drink> barCards;
    private List<Dish> dishList;

    public Category() {
        this.dishList = new ArrayList<>();
        this.barCards = new ArrayList<>();
    }

    public Category(String typeMenu, String nameCategory) {
        this.nameTypeMenu = typeMenu;
        this.nameCategory = nameCategory;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }


    public Category(String typeMenu){
        this.nameTypeMenu = typeMenu;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameTypeMenu() {
        return nameTypeMenu;
    }

    public void setNameTypeMenu(String nameTypeMenu) {
        this.nameTypeMenu = nameTypeMenu;
    }

    public List<Drink> getBarCards(){
        return barCards;
    }

    public List<Dish> getDishList(){
        return dishList;
    }

    public void setBarCards(List<Drink> barCards) {
        this.barCards = barCards;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public void addDishToCategory(Dish dish){
        dishList.add(dish);
    }

    public void addDrinkToCategory(Drink drink){
        barCards.add(drink);
    }

}