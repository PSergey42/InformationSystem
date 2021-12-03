package spring.infoSystem.model;


import java.util.ArrayList;


public class Restaurant {

    private String nameCategory;
    private ArrayList<Menu> dishes;

    public Restaurant(String nameCategory, Menu[] menus) {
        this.nameCategory = nameCategory;
        dishes = new ArrayList();
        for(Menu menu: menus){
            dishes.add(menu);
        }
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public Menu[] getDishes() {
        int i = 0;
        Menu[] menus = new Menu[dishes.size()];
        for(Menu menu: dishes){
            menus[i] = menu;
            i++;
        }
        return menus;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


    public static class Menu {

        private String nameDishes;
        private String nameCategory;
        private double price;

        public Menu(String nameDishes, String nameCategory, double price) {
            this.nameDishes = nameDishes;
            this.nameCategory = nameCategory;
            this.price = price;
        }

        public String getNameDish() {
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


    }
}