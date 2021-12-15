package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO;
import spring.infoSystem.model.BarCard;
import spring.infoSystem.model.Category;
import spring.infoSystem.model.Dish;

@Controller
//@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantDAO dao;

    @Autowired
    public RestaurantController(RestaurantDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String startMenu(){
        return "restaurant/index";
    }

//    @GetMapping("/typeMenu")
//    public String showAllTypeMenu(Model model){
//        model.addAttribute("typeMenu", dao.showTypeMenu());
//        return "restaurant/typeMenu";
//    }

//    @GetMapping("/category")
//    public String showCategoryMenu(Model model){
//        model.addAttribute("newCategory", new Category());
//        model.addAttribute("type", dao.showListCategory());
//        return "restaurant/generalMenu";
//    }

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
        return "restaurant/generalMenuPage";
    }

    @GetMapping("/drink")
    public String showAllDrink(Model model){
        model.addAttribute("barCardIndex", dao.getBarCard());
        return "restaurant/barCardPage";
    }

    @GetMapping("/typeMenu/OneType/category/{nameCategory}")
    public String showMenuByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("newDish", new Dish(nameCategory));
        model.addAttribute("dishIndex", dao.getListDishFromCategory(nameCategory));
        return "restaurant/generalMenuPage";
    }

    @GetMapping("/typeMenu/TwoType/category/{nameCategory}")
    public String showBarCardByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("newBarCard", new BarCard(nameCategory));
        model.addAttribute("barCardIndex", dao.getBarCardFromCategory(nameCategory));
        return "restaurant/barCardPage";
    }

    @PostMapping("/typeMenu/OneType/{typeMenu}")
    public String createDish(@ModelAttribute("dish") Category category){
        dao.insertCategory(category);
        return "redirect:/typeMenu/OneType/{typeMenu}";
    }

    @PostMapping("/typeMenu/TwoType/{typeMenu}")
    public String createDrink(@ModelAttribute("drink") Category category){
        dao.insertCategory(category);
        return "redirect:/typeMenu/TwoType/{typeMenu}";
    }
    @PostMapping("/typeMenu/OneType/category/{nameCategory}")
    public String createMenu(@ModelAttribute("dish") Dish dish){
        dao.insertDish(dish);
        return "redirect:/typeMenu/OneType/category/{nameCategory}";
    }

    @PostMapping("/typeMenu/TwoType/category/{nameCategory}")
    public String createDrink(@ModelAttribute("drink") BarCard drink){
        dao.insertDrink(drink);
        return "redirect:/typeMenu/TwoType/category/{nameCategory}";
    }

    @DeleteMapping("/category/{nameCategory}")
    public String deleteDish(@PathVariable("nameCategory") String name){
        dao.deleteDish(name);
        return "redirect:/menu";
    }

    @DeleteMapping("/{nameDrink}")
    public String deleteDrink(@PathVariable("nameDrink") String name){
        dao.deleteDrink(name);
        return "redirect:/drink";
    }

    @DeleteMapping("/typeMenu")
    public String deleteCategory(@RequestParam(required=false) String nameCategoryDelete){
        dao.deleteCategory(nameCategoryDelete);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchDish(@RequestParam(required=false) String search, Model model){
        model.addAttribute("searchList", dao.searchDish(search));
        return "/restaurant/index";
    }

    @GetMapping("/menu/showDish/{nameMenu}")
    public String showDish(@PathVariable("nameMenu") String nameMenu,
                               Model model){
        //model.addAttribute("editMenu", dao.showMenu(nameMenu));
        model.addAttribute("dishIndex", dao.getDishInfoFromMenu(nameMenu));
        return "/restaurant/showDish";
    }

    @GetMapping("/showDrink/{nameDrink}")
    public String showDrink(@PathVariable("nameDrink") String nameDrink,
                            Model model){
        model.addAttribute("barCardIndex", dao.getDrinkInfoFromBarCard(nameDrink));
        return "/restaurant/showDrink";
    }

    @PatchMapping("/dish/{nameMenu}")
    public String updateDish(@PathVariable("nameMenu") String name,
                         @ModelAttribute("edit") Dish dish){
        dao.updateDish(name, dish);
        return "redirect:/menu/showDish/{nameMenu}";
    }

    @PatchMapping("/drink/{nameDrink}")
    public String updateDrink(@PathVariable("nameDrink") String nameDrink,
                              @ModelAttribute("edit") BarCard drink){
        dao.updateDrink(nameDrink, drink);
        return "redirect:/showDrink/{nameDrink}";
    }

}
