package spring.infoSystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "drink")
@XmlType(propOrder = {"id", "nameDrink", "fortressDrink", "sizeDrink","priceDrink", "category_id"})
public class Drink implements CheckIn{

    private String id;
    String category_id;
    @NotEmpty(message = "Name should not be empty")
    String nameDrink;
    @Min(value = 1, message = "Error")
    double fortressDrink;
    @Min(value = 1, message = "Error")
    double sizeDrink;
    @Min(value = 1, message = "Error")
    double priceDrink;


    public Drink(String nameDrink, double fortressDrink, double sizeDrink, double priceDrink) {
        this.nameDrink = nameDrink;
        this.fortressDrink = fortressDrink;
        this.sizeDrink = sizeDrink;
        this.priceDrink = priceDrink;
    }

    public Drink(){}

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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

    @XmlAttribute
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
