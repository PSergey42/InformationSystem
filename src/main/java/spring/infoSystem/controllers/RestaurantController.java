package spring.infoSystem.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO;
import spring.infoSystem.model.CheckIn;
import spring.infoSystem.model.Drink;
import spring.infoSystem.model.Category;
import spring.infoSystem.model.Dish;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantDAO dao;

    @Autowired
    public RestaurantController(RestaurantDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String startMenu(Model model){
        List<Dish> dishes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<CheckIn> listAll = dao.searchAll("");
        for(int i = 0; i < listAll.size(); i++){
            if(listAll.get(i) instanceof Dish) dishes.add((Dish)listAll.get(i));
            if(listAll.get(i) instanceof Drink) drinks.add((Drink)listAll.get(i));
        }
        model.addAttribute("searchDish", dishes);
        model.addAttribute("searchDrink", drinks);
        return "restaurant/index";
    }

    @GetMapping("/typeMenu/OneType/{typeMenu}")
    public String showGeneralMenuFromType(@PathVariable("typeMenu") String typeMenu, Model model){
        model.addAttribute("newCategory", new Category(typeMenu));
        model.addAttribute("type", dao.showListFromType(typeMenu));
        return "restaurant/generalMenu";
    }

    @GetMapping("/typeMenu/TwoType/{typeMenu}")
    public String showBarCardFromType(@PathVariable("typeMenu") String typeMenu, Model model){
        model.addAttribute("newCategory", new Category(typeMenu));
        model.addAttribute("barCard", dao.showListFromType(typeMenu));
        return "restaurant/barCard";
    }

    @GetMapping("/menu")
    public String showAllMenu(Model model){
        model.addAttribute("dishIndex", dao.showListAllDish());
        return "restaurant/allMenuPage";
    }

    @GetMapping("/drink")
    public String showAllDrink(Model model){
        model.addAttribute("barCardIndex", dao.getBarCard());
        return "restaurant/allBarCardPage";
    }

    @GetMapping("/typeMenu/OneType/category/{nameCategory}")
    public String showMenuByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("newDish", new Dish(nameCategory));
        model.addAttribute("dishIndex", dao.getListDishFromCategory(nameCategory));
        return "restaurant/generalMenuPage";
    }

    @GetMapping("/typeMenu/TwoType/category/{nameCategory}")
    public String showBarCardByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("newBarCard", new Drink(nameCategory));
        model.addAttribute("barCardIndex", dao.getBarCardFromCategory(nameCategory));
        return "restaurant/barCardPage";
    }

    @PostMapping("/typeMenu/OneType/{typeMenu}")
    public String createCategoryOneType(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, Model model, @PathVariable("typeMenu") String typeMenu){
        if(bindingResult.hasErrors()) {
            model.addAttribute("type", dao.showListFromType(typeMenu));
            return "restaurant/generalMenu";
        }
        dao.insertCategory(category);
        return "redirect:/typeMenu/OneType/{typeMenu}";
    }

    @PostMapping("/typeMenu/TwoType/{typeMenu}")
    public String createCategoryTwoType(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, Model model, @PathVariable("typeMenu") String typeMenu){
        if(bindingResult.hasErrors()) {
            model.addAttribute("barCard", dao.showListFromType(typeMenu));
            return "restaurant/barCard";
        }
        dao.insertCategory(category);
        return "redirect:/typeMenu/TwoType/{typeMenu}";
    }
    @PostMapping("/typeMenu/OneType/category/{nameCategory}")
    public String createMenu(@ModelAttribute("newDish") @Valid Dish dish, BindingResult bindingResult, Model model, @PathVariable("nameCategory") String nameCategory){
        if(bindingResult.hasErrors()) {
            model.addAttribute("dishIndex", dao.getListDishFromCategory(nameCategory));
            return "restaurant/generalMenuPage";
        }
        dao.insertDish(dish);
        return "redirect:/typeMenu/OneType/category/{nameCategory}";
    }

    @PostMapping("/typeMenu/TwoType/category/{nameCategory}")
    public String createDrink(@ModelAttribute("newBarCard") @Valid Drink drink, BindingResult bindingResult, Model model, @PathVariable("nameCategory") String nameCategory){
        if(bindingResult.hasErrors()) {
            model.addAttribute("barCardIndex", dao.getBarCardFromCategory(nameCategory));
            return "restaurant/barCardPage";
        }
        dao.insertDrink(drink);
        return "redirect:/typeMenu/TwoType/category/{nameCategory}";
    }

    @DeleteMapping("/category/{nameCategory}")
    public String deleteDish(@PathVariable("nameCategory") String name){
        String x = dao.getDishInfoFromMenu(name).getNameCategory();
        dao.deleteDish(name);
        return "redirect:/typeMenu/OneType/category/" +x;
    }

    @DeleteMapping("/{nameDrink}")
    public String deleteDrink(@PathVariable("nameDrink") String name){
        String x = dao.getDrinkInfoFromBarCard(name).getNameCategory();
        dao.deleteDrink(name);
        return "redirect:/typeMenu/TwoType/category/"+ x;
    }

    @DeleteMapping("/typeMenu/OneType")
    public String deleteCategoryOneType(@RequestParam(required=false) String nameCategoryDelete){
        dao.deleteCategory(nameCategoryDelete);
        return "redirect:/typeMenu/OneType/Menu";
    }

    @DeleteMapping("/typeMenu/TwoType")
    public String deleteCategoryTwoType(@RequestParam(required=false) String nameCategoryDelete){
        dao.deleteCategory(nameCategoryDelete);
        return "redirect:/typeMenu/TwoType/BarCard";
    }

    @PostMapping("/search")
    public String searchAll(@RequestParam(required=false) String search, Model model){
        List<Dish> dishes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<CheckIn> listAll = dao.searchAll(search);
        for(int i = 0; i < listAll.size(); i++){
            if(listAll.get(i) instanceof Dish) dishes.add((Dish)listAll.get(i));
            if(listAll.get(i) instanceof Drink) drinks.add((Drink)listAll.get(i));
        }
        model.addAttribute("searchDish", dishes);
        model.addAttribute("searchDrink", drinks);
        return "/restaurant/index";
    }

    @GetMapping("/menu/showDish/{nameDish}")
    public String showDish(@PathVariable("nameDish") String nameDish,
                               Model model){
        model.addAttribute("dishIndex", dao.getDishInfoFromMenu(nameDish));
        model.addAttribute("editDish", dao.getDishInfoFromMenu(nameDish));
        return "/restaurant/showDish";
    }

    @GetMapping("/showDrink/{nameDrink}")
    public String showDrink(@PathVariable("nameDrink") String nameDrink,
                            Model model){
        model.addAttribute("barCardIndex", dao.getDrinkInfoFromBarCard(nameDrink));
        model.addAttribute("newBarCard", dao.getDrinkInfoFromBarCard(nameDrink));
        return "/restaurant/showDrink";
    }

    @PatchMapping("/dish/{nameDish}")
    public String updateDish(@PathVariable("nameDish") String nameDish,
                         @ModelAttribute("editDish") @Valid Dish dish, BindingResult bindingResult, Model model){
        System.out.println("sss");
        System.out.println(dish.getNameDish());
        System.out.println(dish.getNameCategory());
        System.out.println(dish.getPrice());
        if(bindingResult.hasErrors()) {
            model.addAttribute("dishIndex", dao.getDishInfoFromMenu(nameDish));
            return "restaurant/showDish";
        }
        System.out.println("sss");
        dao.updateDish(nameDish, dish);
        return "redirect:/menu/showDish/{nameDish}";
    }

    @PatchMapping("/drink/{nameDrink}")
    public String updateDrink(@PathVariable("nameDrink") String nameDrink,
                              @ModelAttribute("newBarCard") @Valid Drink drink, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("barCardIndex", dao.getDrinkInfoFromBarCard(nameDrink));
            return "restaurant/showDrink";
        }
        dao.updateDrink(nameDrink, drink);
        return "redirect:/showDrink/{nameDrink}";
    }

    @GetMapping("/save")
    public String saveData() throws IOException {
        dao.saveData();
        return "restaurant/index";
    }

    @GetMapping("/upload")
    public String uploadData(Model model) throws IOException, ClassNotFoundException {
        dao.uploadData();
        return "restaurant/index";
    }
}
