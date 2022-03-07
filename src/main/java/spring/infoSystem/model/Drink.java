package spring.infoSystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Drink implements CheckIn{

    private String id;
    @NotEmpty(message = "Name should not be empty")
    String nameDrink;
    @Min(value = 1, message = "Error")
    double fortressDrink;
    @Min(value = 1, message = "Error")
    double sizeDrink;
    @Min(value = 1, message = "Error")
    double priceDrink;
    String category_id;

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

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", nameDrink='" + nameDrink + '\'' +
                ", fortressDrink=" + fortressDrink +
                ", sizeDrink=" + sizeDrink +
                ", priceDrink=" + priceDrink +
                ", category_id=" + category_id +
                '}';
    }
}
