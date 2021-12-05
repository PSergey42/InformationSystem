package spring.infoSystem.model;

public class Menu {

    private String nameDishes;
    private String nameCategory;
    private double price;

    public Menu(String nameDishes, String nameCategory, double price) {
        this.nameDishes = nameDishes;
        this.nameCategory = nameCategory;
        this.price = price;
    }

    public Menu(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    public Menu() {
    }

    public String getNameDish() {
        return nameDishes;
    }

    public void setNameDish(String nameDishes) {
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
