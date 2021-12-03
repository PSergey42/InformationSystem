package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.infoSystem.dao.DAO;

@Controller
public class FirstController {

    private final DAO dao;

    @Autowired
    public FirstController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/category")
    public String menuCategory(Model model){
        model.addAttribute("category", dao.getAllCategory());
        return "restaurant/menuCategory";
    }

    @GetMapping("/category/{nameCategory}")
    public String menuIndex(@PathVariable("nameCategory") String nameCategory, Model model){
        model.addAttribute("menuIndex", dao.getAllMenu(nameCategory));
        return "restaurant/menuPage";
    }


}
