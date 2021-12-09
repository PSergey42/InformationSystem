package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
import spring.infoSystem.model.DishInfo;
import spring.infoSystem.model.Menu;
import spring.infoSystem.model.Restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class RestaurantDAO {

    private List<Restaurant> categories;

    {

        categories = new ArrayList<>();

        Menu menu12 = new Menu("Mushroom soup", "Soups", 12.5);
        Menu menu13 = new Menu("Cream-Soup", "Soups", 17.0);

        Menu menu22 = new Menu("Mashed potatoes", "Hot Appetizers", 11.9);
        Menu menu23 = new Menu("Fried cheese", "Hot Appetizers", 23.2);

        Menu menu32 = new Menu("SHRIMPS IN TOM-YAM SAUCE", "Snacks", 25.5);
        Menu menu33 = new Menu("Rolls Tinatika", "Snacks", 19.2);

        DishInfo dishInfo11 = new DishInfo("some consist", 273.2, 350.3);
        DishInfo dishInfo12 = new DishInfo("some consist", 124, 312);
        DishInfo dishInfo21 = new DishInfo("some consist", 256, 55);
        DishInfo dishInfo22 = new DishInfo("some consist", 346, 124);
        DishInfo dishInfo31 = new DishInfo("some consist", 1202, 832);
        DishInfo dishInfo32 = new DishInfo("some consist", 993, 323);

        menu12.addDishInfoByMenu(dishInfo11);
        menu13.addDishInfoByMenu(dishInfo12);
        menu22.addDishInfoByMenu(dishInfo21);
        menu23.addDishInfoByMenu(dishInfo22);
        menu32.addDishInfoByMenu(dishInfo31);
        menu33.addDishInfoByMenu(dishInfo32);

        Restaurant category1 = new Restaurant("Soups");
        Restaurant category2 = new Restaurant("Hot Appetizers");
        Restaurant category3 = new Restaurant("Snacks");

        category1.addMenuToCategory(menu12);
        category1.addMenuToCategory(menu13);

        category2.addMenuToCategory(menu22);
        category2.addMenuToCategory(menu23);

        category3.addMenuToCategory(menu32);
        category3.addMenuToCategory(menu33);

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);


    }

    public List<Restaurant> showListCategory(){
        return categories;
    }

    public List<Menu> showListAllMenu(){
        return categories.stream()
                .flatMap(restaurant -> restaurant.getDishes().stream())
                .collect(Collectors.toList());
    }

    public List<Menu> getListMenuFromCategory(String name){
        return categories.stream()
                .flatMap(restaurant -> restaurant.getDishes().stream())
                .filter(menu -> Objects.equals(menu.getNameCategory(), name))
                .collect(Collectors.toList());
    }

    public void save(Restaurant restaurant){
        categories.add(restaurant);
    }

    public void save(Menu menu, DishInfo dish){
        for (Restaurant restaurant: categories){
            if(restaurant.getNameCategory().equals(menu.getNameCategory())) {
                restaurant.addMenuToCategory(menu);
                for (Menu menu1 : restaurant.getDishes()){
                    menu1.addDishInfoByMenu(dish);
                }
            }
        }
    }

    public void deleteMenu(String name){
        for (Restaurant restaurant: categories){
            restaurant.getDishes().removeIf(x -> Objects.equals(x.getNameDish(), name));
        }

    }

    public void deleteCategory(String nameCategory){
        categories.removeIf(c -> c.getNameCategory().equals(nameCategory));
    }

    public List<Menu> searchDish(String search){
        List<Menu> menus = new ArrayList<>();
        for (Restaurant restaurant: categories){
            restaurant.getDishes().stream().filter(x -> x.getNameDish().contains(search)).forEach(menus::add);
        }
        return menus;
    }

    public Menu showMenu(String name){

           return categories.stream().flatMap(restaurant -> restaurant.getDishes().stream())
                    .filter(menu -> Objects.equals(menu.getNameDish(), name))
                    .findAny().orElse(null);

    }

    public DishInfo getDishInfoFromMenu(String name){
        return categories.stream().flatMap(restaurant -> restaurant.getDishes().stream())
                .filter(menu -> Objects.equals(menu.getNameDish(), name))
                .flatMap(menu -> menu.getDishInfos().stream())
                .findAny().orElse(null);
    }

    public void update(String name, DishInfo dish){
        DishInfo dishInfo = getDishInfoFromMenu(name);
        dishInfo.setConsistDish(dish.getConsistDish());
        dishInfo.setCalories(dish.getCalories());
        dishInfo.setWeight(dish.getWeight());
    }

}
