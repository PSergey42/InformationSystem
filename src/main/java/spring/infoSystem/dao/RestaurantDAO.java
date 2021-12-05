package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
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
    public void save(Menu menu){
        for (Restaurant restaurant: categories){
            if(restaurant.getNameCategory().equals(menu.getNameCategory())) restaurant.addMenuToCategory(menu);
        }
    }
    public void deleteMenu(String nameDish){
        for (Restaurant restaurant: categories){
            for (Menu menu: restaurant.getDishes()){
                if(menu.getNameDish().equals(nameDish)) restaurant.deleteDishByName(nameDish);
            }
        }

    }
    public void deleteCategory(String nameCategory){
        categories.removeIf(c -> c.getNameCategory().equals(nameCategory));
    }

}
