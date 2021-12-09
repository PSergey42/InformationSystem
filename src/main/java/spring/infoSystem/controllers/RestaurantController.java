package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO;
import spring.infoSystem.model.DishInfo;
import spring.infoSystem.model.Menu;
import spring.infoSystem.model.Restaurant;

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

    @GetMapping("/category")
    public String showCategoryMenu(Model model){
        model.addAttribute("newCategory", new Restaurant());
        model.addAttribute("category", dao.showListCategory());
        return "restaurant/menuCategory";
    }

    @GetMapping("/menu")
    public String showAllMenu(Model model){
        model.addAttribute("menuIndex", dao.showListAllMenu());
        return "restaurant/menuPage";
    }

    @GetMapping("/category/{nameCategory}")
    public String showMenuByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("newMenu", new Menu(nameCategory));
        model.addAttribute("menuIndex", dao.getListMenuFromCategory(nameCategory));
        return "restaurant/menuPage";
    }

    @PostMapping()
    public String create(@ModelAttribute("restaurant") Restaurant restaurant){
        dao.save(restaurant);
        return "redirect:/category";
    }
    @PostMapping("/category/{nameCategory}")
    public String createMenu(@ModelAttribute("menu") Menu menu,
                            @ModelAttribute("dish") DishInfo dish){
        dao.save(menu, dish);
        return "redirect:/category/{nameCategory}";
    }
    @DeleteMapping("/category/{nameCategory}")
    public String deleteDish(@PathVariable("nameCategory") String name){
        dao.deleteMenu(name);
        return "redirect:/menu";
    }
    @DeleteMapping("/category")
    public String deleteCategory(@RequestParam(required=false) String nameCategoryDelete){
        dao.deleteCategory(nameCategoryDelete);
        return "redirect:/category";
    }

    @PostMapping("/search")
    public String searchDish(@RequestParam(required=false) String search, Model model){
        model.addAttribute("searchList", dao.searchDish(search));
        return "/restaurant/index";
    }

    @GetMapping("/menu/show/{nameMenu}")
    public String showDish(@PathVariable("nameMenu") String nameMenu,
                               Model model){
        model.addAttribute("editMenu", dao.showMenu(nameMenu));
        model.addAttribute("showDish", dao.getDishInfoFromMenu(nameMenu));
        return "restaurant/show";
    }

    @PatchMapping("/{nameMenu}")
    public String update(@PathVariable("nameMenu") String name,
                         @ModelAttribute("edit") DishInfo dish){
        dao.update(name, dish);
        return "redirect:/menu/show/{nameMenu}";
    }

}
