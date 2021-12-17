package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
import spring.infoSystem.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RestaurantDAO {

    private List<TypeMenu> typeMenuList;

    {
        typeMenuList = new ArrayList<>();

        Dish dish11 = new Dish("Mushroom soup","Soups","some consist", 273.2, 350.3, 12.5);
        Dish dish12 = new Dish("Cream-Soup","Soups","some consist", 124, 312, 17.0);

        Dish dish21 = new Dish("Mashed potatoes", "Hot Appetizers","some consist", 256, 55, 11.9);
        Dish dish22 = new Dish("Fried cheese", "Hot Appetizers","some consist", 346, 124, 23.2);

        Dish dish31 = new Dish("SHRIMPS IN TOM-YAM SAUCE", "Snacks","some consist", 1202, 832, 25.5);
        Dish dish32 = new Dish("Rolls Tinatika", "Snacks","some consist", 993, 323, 25.5);

        Drink barCard1 = new Drink("Americano", "Coffee", 0, 0.25, 0.5);
        Drink barCard2 = new Drink("Late", "Coffee", 0, 0.25, 0.5);
        Drink barCard3 = new Drink("Corona Extra", "Beer", 4.5, 0.5, 1);

        Category category1 = new Category("Menu","Soups");
        Category category2 = new Category("Menu","Hot Appetizers");
        Category category3 = new Category("Menu","Snacks");
        Category category4 = new Category("BarCard", "Coffee");
        Category category5 = new Category("BarCard", "Beer");

        TypeMenu typeMenu1 = new TypeMenu("Menu");
        TypeMenu typeMenu2 = new TypeMenu("BarCard");

        category1.addDishToCategory(dish11);
        category1.addDishToCategory(dish12);

        category2.addDishToCategory(dish21);
        category2.addDishToCategory(dish22);

        category3.addDishToCategory(dish31);
        category3.addDishToCategory(dish32);

        category4.addDrinkToCategory(barCard1);
        category4.addDrinkToCategory(barCard2);

        category5.addDrinkToCategory(barCard3);

        typeMenu1.addCategoryToTypeMenu(category1);
        typeMenu1.addCategoryToTypeMenu(category2);
        typeMenu1.addCategoryToTypeMenu(category3);

        typeMenu2.addCategoryToTypeMenu(category4);
        typeMenu2.addCategoryToTypeMenu(category5);

        typeMenuList.add(typeMenu1);
        typeMenuList.add(typeMenu2);

    }

    public List<TypeMenu> showTypeMenu(){
        return typeMenuList;
    }

    public List<Category> showListCategory(){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .collect(Collectors.toList());
    }

    public List<Category> showListFromType(String name){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .filter(category -> Objects.equals(category.getTypeMenu(), name))
                .collect(Collectors.toList());
    }

    public List<Dish> showListAllDish(){
        return typeMenuList.stream().flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getDishList().stream())
                .collect(Collectors.toList());
    }

    public List<Dish> getListDishFromCategory(String name){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getDishList().stream())
                .filter(dish -> Objects.equals(dish.getNameCategory(), name))
                .collect(Collectors.toList());
    }

    public List<Drink> getBarCard(){
        return typeMenuList.stream().flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getBarCards().stream())
                .collect(Collectors.toList());
    }

    public List<Drink> getBarCardFromCategory(String name){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getBarCards().stream())
                .filter(barCard -> Objects.equals(barCard.getNameCategory(), name))
                .collect(Collectors.toList());
    }

    public void insertCategory(Category category){
        for (TypeMenu typeMenu : typeMenuList){
            if (typeMenu.getTypeMenu().equals(category.getTypeMenu())){
                typeMenu.addCategoryToTypeMenu(category);
            }
        }
    }

    public void insertDish(Dish dish){
        for (TypeMenu typeMenu: typeMenuList){
            for (Category category : typeMenu.getCategoryList()){
                if (category.getNameCategory().equals(dish.getNameCategory())){
                    category.addDishToCategory(dish);
                }
            }
        }
    }

    public void insertDrink(Drink drink){
        for (TypeMenu typeMenu: typeMenuList){
            for (Category category : typeMenu.getCategoryList()){
                if (category.getNameCategory().equals(drink.getNameCategory())){
                    category.addDrinkToCategory(drink);
                }
            }
        }
    }

    public void deleteDish(String name){
//        for (Category restaurant: categories){
//            restaurant.getDishList().removeIf(x -> Objects.equals(x.getNameDish(), name));
//        }
        for (TypeMenu typeMenu : typeMenuList){
            for (Category category : typeMenu.getCategoryList()){
                category.getDishList().removeIf(x -> Objects.equals(x.getNameDish(), name));
            }
        }
    }

    public void deleteDrink(String name){
        for (TypeMenu typeMenu : typeMenuList){
            for (Category category : typeMenu.getCategoryList()){
                category.getBarCards().removeIf(x -> Objects.equals(x.getNameDrink(), name));
            }
        }
    }

    public void deleteCategory(String nameCategory){
        //categories.removeIf(c -> c.getNameCategory().equals(nameCategory));
        for (TypeMenu typeMenu : typeMenuList){
            typeMenu.getCategoryList().removeIf(c -> c.getNameCategory().equals(nameCategory));
        }
    }



    public Dish getDishInfoFromMenu(String name){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getDishList().stream())
                .filter(dish -> Objects.equals(dish.getNameDish(), name))
                .findAny().orElse(null);
    }

    public Drink getDrinkInfoFromBarCard(String name){
        return typeMenuList.stream()
                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
                .flatMap(category -> category.getBarCards().stream())
                .filter(barCard -> Objects.equals(barCard.getNameDrink(), name))
                .findAny().orElse(null);
    }

    public void updateDish(String name, Dish dish){
        Dish dishInfo = getDishInfoFromMenu(name);
        dishInfo.setConsistDish(dish.getConsistDish());
        dishInfo.setCalories(dish.getCalories());
        dishInfo.setWeight(dish.getWeight());
        dishInfo.setPrice(dish.getPrice());
    }

    public void updateDrink(String name, Drink drink){
        Drink newDrink = getDrinkInfoFromBarCard(name);
        newDrink.setFortressDrink(drink.getFortressDrink());
        newDrink.setSizeDrink(drink.getSizeDrink());
        newDrink.setPriceDrink(drink.getPriceDrink());
    }

    public List<CheckIn> searchAll(String search){
        List<CheckIn> dishes = new ArrayList<>();
        for (TypeMenu typeMenu : typeMenuList){
            for (Category category : typeMenu.getCategoryList()){
                category.getBarCards().stream().filter(x -> x.getNameDrink().contains(search) || x.getNameCategory().contains(search)).forEach(dishes::add);
                category.getDishList().stream().filter(x -> x.getNameDish().contains(search) || x.getNameCategory().contains(search)).forEach(dishes::add);
            }
        }
        return dishes;
    }

    public void saveData() throws IOException {
        FileOutputStream file =  new FileOutputStream("data.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(typeMenuList);
        out.close();

    }
    public void uploadData() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            typeMenuList = (List<TypeMenu>) in.readObject();
            in.close();
        }
        catch(FileNotFoundException ex){

        }
    }

}
