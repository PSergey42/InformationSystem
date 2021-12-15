package spring.infoSystem.model;

import java.util.ArrayList;
import java.util.List;

public class TypeMenu {

    private String typeMenu;
    private List<Category> categoryList;

    public TypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
        this.categoryList = new ArrayList<>();
    }

    public TypeMenu(){}

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public List<Category> getCategoryList(){
        return categoryList;
    }

    public void addCategoryToTypeMenu(Category category){
        categoryList.add(category);
    }
}
