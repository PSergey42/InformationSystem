package spring.infoSystem.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable {

    private int id;
//    private String nameTypeMenu;
    @NotEmpty(message = "Name should not be empty")
    private String nameCategory;
    private int typeMenu_id;
    private List<Drink> barCards;
    private List<Dish> dishList;

    public Category() {
        this.dishList = new ArrayList<>();
        this.barCards = new ArrayList<>();
    }

    public Category(String nameCategory) {
        //this.nameTypeMenu = typeMenu;
        this.nameCategory = nameCategory;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public Category(int id, String nameCategory, int typeMenu_id) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.typeMenu_id = typeMenu_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getTypeMenu_id() {
        return typeMenu_id;
    }

    public void setTypeMenu_id(int typeMenu_id) {
        this.typeMenu_id = typeMenu_id;
    }


}