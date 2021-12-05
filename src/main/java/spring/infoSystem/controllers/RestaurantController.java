package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantDAO dao;

    @Autowired
    public RestaurantController(RestaurantDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/category")
    public String showCategoryMenu(Model model){
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
        model.addAttribute("menuIndex", dao.getListMenuFromCategory(nameCategory));
        return "restaurant/menuPage";
    }

}
