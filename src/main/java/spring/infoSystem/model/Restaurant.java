package spring.infoSystem.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Restaurant {

    private String nameCategory;
    private List<Menu> dishes;

    public Restaurant(String nameCategory) {
        this.nameCategory = nameCategory;
        this.dishes = new ArrayList<>();
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

    public void addMenuToCategory(Menu menu){
        dishes.add(menu);
    }

}