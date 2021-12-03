package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
import spring.infoSystem.model.Restaurant.Menu;
import spring.infoSystem.model.Restaurant;

import java.util.ArrayList;

@Component
public class DAO {
    private ArrayList<Restaurant> restaurant;

    {
        restaurant = new ArrayList();

        restaurant.add(new Restaurant("Soups",new Menu[] {new Menu("Mushroom soup", "Soups", 12.5),
                new Menu("Cream-Soup", "Soups", 17.0)}));
        restaurant.add(new Restaurant("Hot Appetizers",new Menu[]{new Menu("Mashed potatoes", "Hot Appetizers", 11.9),
                new Menu("Fried cheese", "Hot Appetizers", 23.2)}));
        restaurant.add(new Restaurant("Snacks",new Menu[]{new Menu("SHRIMPS IN TOM-YAM SAUCE", "Snacks", 25.5),
                new Menu("Rolls Tinatika", "Snacks", 19.2)}));

    }
    public ArrayList<Restaurant> getAllCategory(){
        return restaurant;
    }
    public Menu[] getAllMenu(String nameCategory){
        for(Restaurant category: restaurant){
            if(category.getNameCategory().equals(nameCategory)) return category.getDishes();
        }
        return null;
    }
}
