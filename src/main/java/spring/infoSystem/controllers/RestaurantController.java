package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import spring.infoSystem.dao.RestaurantDAO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO_DB;
import spring.infoSystem.model.Category;
import spring.infoSystem.model.CheckIn;
import spring.infoSystem.model.Dish;
import spring.infoSystem.model.Drink;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantDAO_DB dao_db;

    @Autowired
    public RestaurantController(RestaurantDAO_DB dao_db) {
        this.dao_db = dao_db;
    }

    @GetMapping()
    public String startMenu(Model model){
        List<Dish> dishes = dao_db.indexDish();
        List<Drink> drinks = dao_db.indexDrink();

        model.addAttribute("searchDish", dishes);
        model.addAttribute("searchDrink", drinks);

        return "restaurant/index";
    }


    //Category controller
    @GetMapping("/category/Menu/{typeMenu_id}")
    public String indexMenuCategoryFromTypeMenu(@PathVariable("typeMenu_id") int typeMenu_id,
                                                @ModelAttribute("newCategory") Category category, Model model){
        model.addAttribute("category", dao_db.indexCategory(typeMenu_id));
        return "restaurant/generalMenu";
    }

    @PostMapping("/category/Menu/{typeMenu_id}")
    public String addCategoryMenu(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, @PathVariable("typeMenu_id") int typeMenu_id,
                                  Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("category", dao_db.indexCategory(typeMenu_id));
            return "restaurant/generalMenu";
        }
        dao_db.insertCategory(category, typeMenu_id);
        return "redirect:/category/Menu/{typeMenu_id}";
    }

    @DeleteMapping("/categoryMenu/{nameCategory}")
    public String deleteCategoryMenu(@PathVariable("nameCategory") String nameCategoryMenu){
        dao_db.deleteCategory(nameCategoryMenu, 1);
        return "redirect:/category/Menu/1";
    }

    @GetMapping("/category/BarCard/{typeMenu_id}")
    public String indexBarCardCategoryFromTypeMenu(@PathVariable("typeMenu_id") int typeMenu_id,
                                                   @ModelAttribute("newCategory") Category category, Model model){
        model.addAttribute("category", dao_db.indexCategory(typeMenu_id));
        return "restaurant/barCard";
    }

    @PostMapping("/category/BarCard/{typeMenu_id}")
    public String addCategoryBarCard(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, @PathVariable("typeMenu_id") int typeMenu_id,
                                  Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("category", dao_db.indexCategory(typeMenu_id));
            return "restaurant/barCard";
        }
        dao_db.insertCategory(category, typeMenu_id);
        return "redirect:/category/BarCard/{typeMenu_id}";
    }

    @DeleteMapping("/categoryBarCard/{nameCategory}")
    public String deleteCategoryBarCard(@PathVariable("nameCategory") String nameCategoryMenu){
        dao_db.deleteCategory(nameCategoryMenu, 2);
        return "redirect:/category/Menu/2";
    }

    //Dish controller
    @GetMapping("/menu")
    public String showAllMenu(Model model){
        model.addAttribute("dishIndex", dao_db.indexDish());
        return "restaurant/allMenuPage";
    }

    @GetMapping("/menu/{category_id}")
    public String indexDishFromCategory(@ModelAttribute("newDish") Dish dish, @PathVariable("category_id") String category_id,
                                        Model model){
        model.addAttribute("dishFromCategory", dao_db.indexDishFromCategory(category_id));
        return "restaurant/generalMenuPage";
    }

    @PostMapping("/menu/{category_id}")
    public String addDish(@ModelAttribute("newDish") @Valid Dish dish, BindingResult bindingResult, @PathVariable("category_id") String category_id, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("dishFromCategory", dao_db.indexDishFromCategory(category_id));
            return "restaurant/generalMenuPage";
        }
        dao_db.addDish(dish, category_id);
        return "redirect:/menu/{category_id}";
    }

    @GetMapping("/menuInfo/{nameDish}")
    public String infoDish(@PathVariable("nameDish") String nameDish, Model model){
        model.addAttribute("infoDish", dao_db.infoDish(nameDish));
        model.addAttribute("editDish", dao_db.infoDish(nameDish));
        return "restaurant/showDish";
    }

    @PatchMapping("/dish/{nameDish}")
    public String updateDish(@PathVariable("nameDish") String nameDish,
                             @ModelAttribute("editDish") @Valid Dish dish, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("infoDish", dao_db.infoDish(nameDish));
            return "restaurant/showDish";
        }
        dao_db.updateDish(nameDish, dish);
        return "redirect:/menuInfo/{nameDish}";
    }

    @DeleteMapping("/dishInfo/{nameDish}")
    public String deleteDish(@PathVariable("nameDish") String nameDish){
        String x = dao_db.infoDish(nameDish).getCategory_id();
        dao_db.deleteDish(nameDish);
        return "redirect:/menu/" + x;
    }

    //Drink controller
    @GetMapping("/drink")
    public String showAllDrink(Model model){
        model.addAttribute("drinkIndex", dao_db.indexDrink());
        return "restaurant/allBarCardPage";
    }

    @GetMapping("/barCard/{category_id}")
    public String indexDrinkFromCategory(@ModelAttribute("newDrink") Drink drink, @PathVariable("category_id") String category_id,
                                        Model model){
        model.addAttribute("drinkFromCategory", dao_db.indexDrinkFromCategory(category_id));
        return "restaurant/barCardPage";
    }

    @PostMapping("/barCard/{category_id}")
    public String addDrink(@ModelAttribute("newDrink") @Valid Drink drink, BindingResult bindingResult, @PathVariable("category_id") String category_id, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("drinkFromCategory", dao_db.indexDrinkFromCategory(category_id));
            return "restaurant/barCardPage";
        }
        dao_db.addDrink(drink, category_id);
        return "redirect:/barCard/{category_id}";
    }

    @GetMapping("/infoDrink/{nameDrink}")
    public String infoDrink(@PathVariable("nameDrink") String nameDrink, Model model){
        model.addAttribute("infoDrink", dao_db.infoDrink(nameDrink));
        model.addAttribute("editDrink", dao_db.infoDrink(nameDrink));
        return "restaurant/showDrink";
    }

    @PatchMapping("/drink/{nameDrink}")
    public String updateDrink(@PathVariable("nameDrink") String nameDrink,
                             @ModelAttribute("editDrink") @Valid Drink drink, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("infoDrink", dao_db.infoDrink(nameDrink));
            return "restaurant/showDish";
        }
        dao_db.updateDrink(nameDrink, drink);
        return "redirect:/infoDrink/{nameDrink}";
    }

    @DeleteMapping("/barCardInfo/{nameDrink}")
    public String deleteDrink(@PathVariable("nameDrink") String nameDrink){
        String x = dao_db.infoDrink(nameDrink).getCategory_id();
        dao_db.deleteDrink(nameDrink);
        return "redirect:/barCard/" + x;
    }


    //search
    @PostMapping("/search")
    public String searchAll(@RequestParam(required=false) String search, Model model){
        List<Dish> dishes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<CheckIn> listAll = dao_db.search(search);
        for(int i = 0; i < listAll.size(); i++){
            if(listAll.get(i) instanceof Dish) dishes.add((Dish)listAll.get(i));
            if(listAll.get(i) instanceof Drink) drinks.add((Drink)listAll.get(i));
        }
        model.addAttribute("searchDish", dishes);
        model.addAttribute("searchDrink", drinks);
        return "/restaurant/index";
    }

}
