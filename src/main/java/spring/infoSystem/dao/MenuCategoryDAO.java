package spring.infoSystem.dao;

import org.springframework.stereotype.Component;
import spring.infoSystem.model.MenuCategory;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuCategoryDAO {

    private List<MenuCategory> menuCategories;

    {
        menuCategories = new ArrayList<>();

        menuCategories.add(new MenuCategory("Soups"));
        menuCategories.add(new MenuCategory("Hot Appetizers"));
        menuCategories.add(new MenuCategory("Snacks"));

    }

    public List<MenuCategory> allCategory(){
        return menuCategories;
    }

}
