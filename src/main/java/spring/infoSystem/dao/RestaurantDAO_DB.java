package spring.infoSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.infoSystem.model.*;

import java.util.List;

@Component
public class RestaurantDAO_DB {

    private final JdbcTemplate jdbcTemplate;

    private static int CATEGORY_ID = 100;
    private static int DISH_ID = 200;
    private static int DRINK_ID = 300;

    @Autowired
    public RestaurantDAO_DB(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //Category
    public List<Category> indexCategory(int typeMenu_id){
        return jdbcTemplate.query("SELECT category.id, nameCategory FROM category " +
                        "INNER JOIN typemenu t ON category.typeMenu_id = t.id " +
                        "WHERE t.id = ? ", new Object[]{typeMenu_id},
                new BeanPropertyRowMapper<>(Category.class));
    }

    public void insertCategory(Category category, int typeMenu_id){
        jdbcTemplate.update("INSERT INTO category VALUES (?, ?, ?)", ++CATEGORY_ID, category.getNameCategory(), typeMenu_id);
    }

    public void deleteCategory(String nameCategory){
        jdbcTemplate.update("DELETE FROM category WHERE nameCategory=?", nameCategory);
    }

    //Dish
    public List<Dish> indexDish(){
        return jdbcTemplate.query("SELECT * FROM dish", new BeanPropertyRowMapper<>(Dish.class));
    }

    public List<Dish> indexDishFromCategory(int nameCategory_id){
        return jdbcTemplate.query("SELECT * FROM dish " +
                        "INNER JOIN category c on dish.category_id = c.id " +
                        "WHERE c.id = ?", new Object[]{nameCategory_id}, new BeanPropertyRowMapper<>(Dish.class));
    }

    public void addDish(Dish dish, int category_id){
        jdbcTemplate.update("INSERT INTO dish VALUES (?,?,?,?,?,?,?)", ++DISH_ID, dish.getNameDish(), dish.getConsistDish(),
                        dish.getCalories(), dish.getWeight(), dish.getPrice(), category_id);
    }

    public Dish infoDish(String nameDish){
        return jdbcTemplate.query("SELECT * FROM dish WHERE nameDish=?", new Object[]{nameDish},
                        new BeanPropertyRowMapper<>(Dish.class)).stream().findAny().orElse(null);
    }

    public void updateDish(String nameDish, Dish dish){
        jdbcTemplate.update("UPDATE dish SET consistDish=?, calories=?, weight=?, price=? WHERE nameDish=?",
                        dish.getConsistDish(), dish.getCalories(), dish.getWeight(), dish.getPrice(), nameDish);
    }

    public void deleteDish(String nameDish){
        jdbcTemplate.update("DELETE FROM dish WHERE nameDish=?", nameDish);
    }

    //Drink
    public List<Drink> indexDrink(){
        return jdbcTemplate.query("SELECT * FROM drink", new BeanPropertyRowMapper<>(Drink.class));
    }

    public List<Drink> indexDrinkFromCategory(int nameCategory_id){
        return jdbcTemplate.query("SELECT * FROM drink " +
                        "INNER JOIN category c on drink.category_id = c.id " +
                        "WHERE c.id = ?", new Object[]{nameCategory_id}, new BeanPropertyRowMapper<>(Drink.class));
    }

//    public List<> indexAll(int category_id){
//        return jdbcTemplate.query("SELECT * FROM category " +
//                "left join dish on category.id = dish.category_id " +
//                "left join drink d on category.id = d.category_id " +
//                "where category.id = ?", new Object[]{category_id},
//                new BeanPropertyRowMapper<>());
//    }

}
