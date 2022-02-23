package spring.infoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import spring.infoSystem.dao.RestaurantDAO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.infoSystem.dao.RestaurantDAO_DB;
import spring.infoSystem.model.Category;
import spring.infoSystem.model.Dish;

@Controller
//@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantDAO_DB dao_db;

    @Autowired
    public RestaurantController(RestaurantDAO_DB dao_db) {
        this.dao_db = dao_db;
    }

    @GetMapping()
    public String startMenu(){
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
    public String addCategoryMenu(@ModelAttribute("category") Category category, @PathVariable("typeMenu_id") int typeMenu_id,
                              Model model){
        dao_db.insertCategory(category, typeMenu_id);
        return "redirect:/category/Menu/{typeMenu_id}";
    }

    @DeleteMapping("/category/Menu")
    public String deleteCategoryMenu(@RequestParam(required=false) String nameCategoryMenu){
        dao_db.deleteCategory(nameCategoryMenu);
        return "redirect:/category/Menu/{typeMenu_id}";
    }

    @GetMapping("/category/BarCard/{typeMenu_id}")
    public String indexBarCardCategoryFromTypeMenu(@PathVariable("typeMenu_id") int typeMenu_id, Model model){
        model.addAttribute("category", dao_db.indexCategory(typeMenu_id));
        return "restaurant/barCard";
    }

    //Dish controller
    @GetMapping("/menu")
    public String showAllMenu(Model model){
        model.addAttribute("dishIndex", dao_db.indexDish());
        return "restaurant/allMenuPage";
    }

    @GetMapping("/menu/{category_id}")
    public String indexDishFromCategory(@ModelAttribute("newDish") Dish dish, @PathVariable("category_id") int category_id,
                                        Model model){
        model.addAttribute("dishFromCategory", dao_db.indexDishFromCategory(category_id));
        return "restaurant/generalMenuPage";
    }

    @PostMapping("/menu/{category_id}")
    public String addDish(@ModelAttribute("dish") Dish dish, @PathVariable("category_id") int category_id){
        dao_db.addDish(dish, category_id);
        return "redirect:/menu/{category_id}";
    }

    //Drink controller
    @GetMapping("/drink")
    public String showAllDrink(Model model){
        model.addAttribute("drinkIndex", dao_db.indexDrink());
        return "restaurant/allBarCardPage";
    }

    @GetMapping("/barCard/{category_id}")
    public String indexDrinkFromCategory(@PathVariable("category_id") int category_id,
                                        Model model){
        model.addAttribute("drinkFromCategory", dao_db.indexDrinkFromCategory(category_id));
        return "restaurant/barCardPage";
    }

//    private final RestaurantDAO dao;
//
//    @Autowired
//    public RestaurantController(RestaurantDAO dao) {
//        this.dao = dao;
//    }
//
//    @GetMapping()
//    public String startMenu(Model model){
//        List<Dish> dishes = new ArrayList<>();
//        List<Drink> drinks = new ArrayList<>();
//        List<CheckIn> listAll = dao.searchAll("");
//        for(int i = 0; i < listAll.size(); i++){
//            if(listAll.get(i) instanceof Dish) dishes.add((Dish)listAll.get(i));
//            if(listAll.get(i) instanceof Drink) drinks.add((Drink)listAll.get(i));
//        }
//        model.addAttribute("searchDish", dishes);
//        model.addAttribute("searchDrink", drinks);
//        return "restaurant/index";
//    }
//
//    @GetMapping("/typeMenu/OneType/{typeMenu}")
//    public String showGeneralMenuFromType(@PathVariable("typeMenu") String typeMenu, Model model){
//        model.addAttribute("newCategory", new Category(typeMenu));
//        model.addAttribute("type", dao.showListFromType(typeMenu));
//        return "restaurant/generalMenu";
//    }
//
//    @GetMapping("/typeMenu/TwoType/{typeMenu}")
//    public String showBarCardFromType(@PathVariable("typeMenu") String typeMenu, Model model){
//        model.addAttribute("newCategory", new Category(typeMenu));
//        model.addAttribute("barCard", dao.showListFromType(typeMenu));
//        return "restaurant/barCard";
//    }
//
//    @GetMapping("/menu")
//    public String showAllMenu(Model model){
//        model.addAttribute("dishIndex", dao.showListAllDish());
//        return "restaurant/allMenuPage";
//    }
//
//    @GetMapping("/drink")
//    public String showAllDrink(Model model){
//        model.addAttribute("barCardIndex", dao.getBarCard());
//        return "restaurant/allBarCardPage";
//    }
//
//    @GetMapping("/typeMenu/OneType/category/{nameCategory}")
//    public String showMenuByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
//        model.addAttribute("newDish", new Dish(nameCategory));
//        model.addAttribute("dishIndex", dao.getListDishFromCategory(nameCategory));
//        return "restaurant/generalMenuPage";
//    }
//
//    @GetMapping("/typeMenu/TwoType/category/{nameCategory}")
//    public String showBarCardByCategory(@PathVariable("nameCategory") String nameCategory, Model model){
//        model.addAttribute("newBarCard", new Drink(nameCategory));
//        model.addAttribute("barCardIndex", dao.getBarCardFromCategory(nameCategory));
//        return "restaurant/barCardPage";
//    }
//
//    @PostMapping("/typeMenu/OneType/{typeMenu}")
//    public String createCategoryOneType(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, Model model, @PathVariable("typeMenu") String typeMenu){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("type", dao.showListFromType(typeMenu));
//            return "restaurant/generalMenu";
//        }
//        dao.insertCategory(category);
//        return "redirect:/typeMenu/OneType/{typeMenu}";
//    }
//
//    @PostMapping("/typeMenu/TwoType/{typeMenu}")
//    public String createCategoryTwoType(@ModelAttribute("newCategory") @Valid Category category, BindingResult bindingResult, Model model, @PathVariable("typeMenu") String typeMenu){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("barCard", dao.showListFromType(typeMenu));
//            return "restaurant/barCard";
//        }
//        dao.insertCategory(category);
//        return "redirect:/typeMenu/TwoType/{typeMenu}";
//    }
//    @PostMapping("/typeMenu/OneType/category/{nameCategory}")
//    public String createMenu(@ModelAttribute("newDish") @Valid Dish dish, BindingResult bindingResult, Model model, @PathVariable("nameCategory") String nameCategory){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("dishIndex", dao.getListDishFromCategory(nameCategory));
//            return "restaurant/generalMenuPage";
//        }
//        dao.insertDish(dish);
//        return "redirect:/typeMenu/OneType/category/{nameCategory}";
//    }
//
//    @PostMapping("/typeMenu/TwoType/category/{nameCategory}")
//    public String createDrink(@ModelAttribute("newBarCard") @Valid Drink drink, BindingResult bindingResult, Model model, @PathVariable("nameCategory") String nameCategory){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("barCardIndex", dao.getBarCardFromCategory(nameCategory));
//            return "restaurant/barCardPage";
//        }
//        dao.insertDrink(drink);
//        return "redirect:/typeMenu/TwoType/category/{nameCategory}";
//    }
//
//    @DeleteMapping("/category/{nameCategory}")
//    public String deleteDish(@PathVariable("nameCategory") String name){
//        String x = dao.getDishInfoFromMenu(name).getNameCategory();
//        dao.deleteDish(name);
//        return "redirect:/typeMenu/OneType/category/" +x;
//    }
//
//    @DeleteMapping("/{nameDrink}")
//    public String deleteDrink(@PathVariable("nameDrink") String name){
//        String x = dao.getDrinkInfoFromBarCard(name).getNameCategory();
//        dao.deleteDrink(name);
//        return "redirect:/typeMenu/TwoType/category/"+ x;
//    }
//
//    @DeleteMapping("/typeMenu/OneType")
//    public String deleteCategoryOneType(@RequestParam(required=false) String nameCategoryDelete){
//        dao.deleteCategory(nameCategoryDelete);
//        return "redirect:/typeMenu/OneType/Menu";
//    }
//
//    @DeleteMapping("/typeMenu/TwoType")
//    public String deleteCategoryTwoType(@RequestParam(required=false) String nameCategoryDelete){
//        dao.deleteCategory(nameCategoryDelete);
//        return "redirect:/typeMenu/TwoType/BarCard";
//    }
//
//    @PostMapping("/search")
//    public String searchAll(@RequestParam(required=false) String search, Model model){
//        List<Dish> dishes = new ArrayList<>();
//        List<Drink> drinks = new ArrayList<>();
//        List<CheckIn> listAll = dao.searchAll(search);
//        for(int i = 0; i < listAll.size(); i++){
//            if(listAll.get(i) instanceof Dish) dishes.add((Dish)listAll.get(i));
//            if(listAll.get(i) instanceof Drink) drinks.add((Drink)listAll.get(i));
//        }
//        model.addAttribute("searchDish", dishes);
//        model.addAttribute("searchDrink", drinks);
//        return "/restaurant/index";
//    }
//
//    @GetMapping("/menu/showDish/{nameDish}")
//    public String showDish(@PathVariable("nameDish") String nameDish,
//                               Model model){
//        model.addAttribute("dishIndex", dao.getDishInfoFromMenu(nameDish));
//        model.addAttribute("editDish", dao.getDishInfoFromMenu(nameDish));
//        return "/restaurant/showDish";
//    }
//
//    @GetMapping("/showDrink/{nameDrink}")
//    public String showDrink(@PathVariable("nameDrink") String nameDrink,
//                            Model model){
//        model.addAttribute("barCardIndex", dao.getDrinkInfoFromBarCard(nameDrink));
//        model.addAttribute("newBarCard", dao.getDrinkInfoFromBarCard(nameDrink));
//        return "/restaurant/showDrink";
//    }
//
//    @PatchMapping("/dish/{nameDish}")
//    public String updateDish(@PathVariable("nameDish") String nameDish,
//                         @ModelAttribute("editDish") @Valid Dish dish, BindingResult bindingResult, Model model){
//        System.out.println("sss");
//        System.out.println(dish.getNameDish());
//        System.out.println(dish.getNameCategory());
//        System.out.println(dish.getPrice());
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("dishIndex", dao.getDishInfoFromMenu(nameDish));
//            return "restaurant/showDish";
//        }
//        System.out.println("sss");
//        dao.updateDish(nameDish, dish);
//        return "redirect:/menu/showDish/{nameDish}";
//    }
//
//    @PatchMapping("/drink/{nameDrink}")
//    public String updateDrink(@PathVariable("nameDrink") String nameDrink,
//                              @ModelAttribute("newBarCard") @Valid Drink drink, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("barCardIndex", dao.getDrinkInfoFromBarCard(nameDrink));
//            return "restaurant/showDrink";
//        }
//        dao.updateDrink(nameDrink, drink);
//        return "redirect:/showDrink/{nameDrink}";
//    }
//
//    @GetMapping("/save")
//    public String saveData() throws IOException, ParserConfigurationException, TransformerException, XMLStreamException {
//        dao.saveData();
//        return "redirect:/";
//    }
//
//    @GetMapping("/upload")
//    public String uploadData(Model model) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
//        dao.uploadData();
//        return "redirect:/";
//    }
}
