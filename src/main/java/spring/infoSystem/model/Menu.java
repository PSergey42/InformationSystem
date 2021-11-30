package spring.infoSystem.model;

public class Menu {

    public String nameDishes;
    public String nameCategory;
    public double price;

    public Menu(String nameDishes, String nameCategory, double price) {
        this.nameDishes = nameDishes;
        this.nameCategory = nameCategory;
        this.price = price;
    }

    public String getNameDishes() {
        return nameDishes;
    }

    public void setNameDishes(String nameDishes) {
        this.nameDishes = nameDishes;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
