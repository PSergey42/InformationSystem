package spring.infoSystem.model;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
public class Dish implements CheckIn {
    @NotEmpty(message = "Name should not be empty")
    String nameDish;
    String nameCategory;
    @NotEmpty(message = "Name should not be empty")
    String consistDish;
    @Min(value = 0, message = "Error")
    double calories;
    @Min(value = 0, message = "Error")
    double weight;
    @Min(value = 0, message = "Error")
    double price;

    public Dish(String nameDish, String nameCategory, String consistDish,
                double calories, double weight, double price) {
        this.nameDish = nameDish;
        this.nameCategory = nameCategory;
        this.consistDish = consistDish;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    public Dish(){}

    public Dish(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getConsistDish() {
        return consistDish;
    }

    public void setConsistDish(String consistDish) {
        this.consistDish = consistDish;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
