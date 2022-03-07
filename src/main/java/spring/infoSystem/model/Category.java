package spring.infoSystem.model;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "category")
@XmlType(propOrder = {"id", "nameCategory", "typeMenu_id", "barCards", "dishList"})
public class Category implements Serializable {

    private String id;
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
        this.nameCategory = nameCategory;
        this.barCards = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public Category(String id, String nameCategory, int typeMenu_id) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.typeMenu_id = typeMenu_id;
    }

    @XmlElementWrapper(name="drinks", nillable = true)
    @XmlElement(name = "drink")
    public List<Drink> getBarCards() {
        return barCards;
    }

    public void setBarCards(List<Drink> barCards) {
        this.barCards = barCards;
    }

    @XmlElementWrapper(name="dishes", nillable = true)
    @XmlElement(name = "dish")
    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    @XmlAttribute
    public int getTypeMenu_id() {
        return typeMenu_id;
    }

    public void setTypeMenu_id(int typeMenu_id) {
        this.typeMenu_id = typeMenu_id;
    }


}