package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
import spring.infoSystem.model.Menu;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuDAO {

    private List<Menu> menu;

    {
        menu = new ArrayList<>();

        menu.add(new Menu("Mushroom soup", "Soups", 12.5));
        menu.add(new Menu("Cream-Soup", "Soups", 17.0));
        menu.add(new Menu("Mashed potatoes", "Hot Appetizers", 11.9));
        menu.add(new Menu("Fried cheese", "Hot Appetizers", 23.2));
        menu.add(new Menu("SHRIMPS IN TOM-YAM SAUCE", "Snacks", 25.5));
        menu.add(new Menu("Rolls Tinatika", "Snacks", 19.2));
    }

    public List<Menu> menuIndex(){
        return menu;
    }

}
