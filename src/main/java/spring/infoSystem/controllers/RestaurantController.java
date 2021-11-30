package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.infoSystem.dao.MenuCategoryDAO;
import spring.infoSystem.dao.MenuDAO;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

        private final MenuCategoryDAO menuCategoryDAO;
        private final MenuDAO menuDAO;

        @Autowired
        public RestaurantController(MenuCategoryDAO menuCategoryDAO, MenuDAO menuDAO) {
                this.menuCategoryDAO = menuCategoryDAO;
                this.menuDAO = menuDAO;
        }

        @GetMapping("/category")
        public String menuCategory(Model model){
                model.addAttribute("category", menuCategoryDAO.allCategory());
                return "restaurant/menuCategory";
        }

        @GetMapping("/category/menu")
        public String menuIndex(Model model){
                model.addAttribute("menuIndex", menuDAO.menuIndex());
                return "restaurant/menuPage";
        }

}
