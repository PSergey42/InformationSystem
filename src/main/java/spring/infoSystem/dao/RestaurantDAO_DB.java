package spring.infoSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.infoSystem.model.*;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RestaurantDAO_DB {

    private final JdbcTemplate jdbcTemplate;

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
        jdbcTemplate.update("INSERT INTO category VALUES (?, ?, ?)", UUID.randomUUID().toString(), category.getNameCategory(), typeMenu_id);
    }

    public void deleteCategory(String nameCategory, int typeMenu_id){
        Category c = jdbcTemplate.query("SELECT * FROM category WHERE nameCategory=? and typeMenu_id=?",
                new BeanPropertyRowMapper<>(Category.class), nameCategory, typeMenu_id).stream().findAny().orElse(null);
        if(typeMenu_id == 2) jdbcTemplate.update("DELETE FROM drink WHERE category_id=?", c.getId());
        else jdbcTemplate.update("DELETE FROM dish WHERE category_id=?", c.getId());
        jdbcTemplate.update("DELETE FROM category WHERE nameCategory=? and typeMenu_id=? ", nameCategory, typeMenu_id);
    }


    //Dish
    public List<Dish> indexDish(){
        return jdbcTemplate.query("SELECT * FROM dish", new BeanPropertyRowMapper<>(Dish.class));
    }

    public List<Dish> indexDishFromCategory(String nameCategory_id){
        return jdbcTemplate.query("SELECT * FROM dish WHERE category_id=?", new BeanPropertyRowMapper<>(Dish.class), nameCategory_id);
    }

    public void addDish(Dish dish, String category_id){
        jdbcTemplate.update("INSERT INTO dish VALUES (?,?,?,?,?,?,?)", UUID.randomUUID().toString(), dish.getNameDish(), dish.getConsistDish(),
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

    public List<Drink> indexDrinkFromCategory(String nameCategory_id){
        return jdbcTemplate.query("SELECT * FROM drink WHERE category_id=?", new BeanPropertyRowMapper<>(Drink.class), nameCategory_id);
    }


    public void addDrink(Drink drink, String category_id){
        jdbcTemplate.update("INSERT INTO drink VALUES (?,?,?,?,?,?)", UUID.randomUUID().toString(), drink.getNameDrink(), drink.getFortressDrink(),
                drink.getSizeDrink(), drink.getPriceDrink(), category_id);
    }

    public Drink infoDrink(String nameDrink){
        return jdbcTemplate.query("SELECT * FROM drink WHERE nameDrink=?", new Object[]{nameDrink},
                new BeanPropertyRowMapper<>(Drink.class)).stream().findAny().orElse(null);
    }

    public void updateDrink(String nameDrink, Drink drink){
        jdbcTemplate.update("UPDATE drink SET fortressDrink=?, sizeDrink=?, priceDrink=? WHERE nameDrink=?",
                drink.getFortressDrink(), drink.getSizeDrink(), drink.getPriceDrink(), nameDrink);
    }

    public void deleteDrink(String nameDrink){
        jdbcTemplate.update("DELETE FROM drink WHERE nameDrink=?", nameDrink);
    }


    public List<CheckIn> search(String name){
        List<CheckIn> search = new ArrayList<>();
        List<Dish> dishes;
        List<Drink> drinks;
        dishes = jdbcTemplate.query("SELECT nameDish FROM dish ", new BeanPropertyRowMapper<>(Dish.class));
        drinks = jdbcTemplate.query("SELECT nameDrink FROM drink ", new BeanPropertyRowMapper<>(Drink.class));

        drinks.stream().filter(x -> x.getNameDrink().toUpperCase().trim().contains(name.toUpperCase().trim())).forEach(search::add);
        dishes.stream().filter(x -> x.getNameDish().toUpperCase().trim().contains(name.toUpperCase().trim())).forEach(search::add);
        return search;
    }

}
