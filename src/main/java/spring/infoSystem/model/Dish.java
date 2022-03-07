package spring.infoSystem.model;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
public class Dish implements CheckIn {

    private String id;
    @NotEmpty(message = "Name should not be empty")
    String nameDish;
    @NotEmpty(message = "Name should not be empty")
    String consistDish;
    @Min(value = 1, message = "Error")
    double calories;
    @Min(value = 1, message = "Error")
    double weight;
    @Min(value = 1, message = "Error")
    double price;
    String category_id;

    public Dish(String nameDish, String consistDish,
                double calories, double weight, double price) {
        this.nameDish = nameDish;
        this.consistDish = consistDish;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    public Dish(){}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", nameDish='" + nameDish + '\'' +
                ", consistDish='" + consistDish + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
