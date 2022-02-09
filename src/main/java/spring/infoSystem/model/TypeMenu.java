package spring.infoSystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeMenu implements Serializable {

    private String nameTypeMenu;
    private List<Category> categoryList;

    public TypeMenu(String typeMenu) {
        this.nameTypeMenu = typeMenu;
        this.categoryList = new ArrayList<>();
    }

    public TypeMenu(){
        this.categoryList = new ArrayList<>();
    }

    public String getNameTypeMenu() {
        return nameTypeMenu;
    }

    public void setNameTypeMenu(String nameTypeMenu) {
        this.nameTypeMenu = nameTypeMenu;
    }

    public List<Category> getCategoryList(){
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    public void addCategoryToTypeMenu(Category category){
        categoryList.add(category);
    }

    public int getSizeCategory(){
        return categoryList.size();
    }


}
