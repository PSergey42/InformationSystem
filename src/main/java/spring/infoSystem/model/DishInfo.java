package spring.infoSystem.model;

public class DishInfo {

    String consistDish;
    double calories;
    double weight;

    public DishInfo(String consistDish, double calories, double weight) {
        this.consistDish = consistDish;
        this.calories = calories;
        this.weight = weight;
    }

    public DishInfo(){}

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
}
