package spring.infoSystem.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TypeMenu")
@XmlType(propOrder = {"id", "nameTypeMenu", "categoryList"})
public class TypeMenu implements Serializable {

    private int id;
    private String nameTypeMenu;
    private List<Category> categoryList;

    public TypeMenu(String typeMenu) {
        this.nameTypeMenu = typeMenu;
        this.categoryList = new ArrayList<>();
    }

    public TypeMenu(int id, String nameTypeMenu) {
        this.id = id;
        this.nameTypeMenu = nameTypeMenu;
        this.categoryList = new ArrayList<>();
    }

    public TypeMenu(int id, String nameTypeMenu, List<Category> categoryList) {
        this.id = id;
        this.nameTypeMenu = nameTypeMenu;
        this.categoryList = categoryList;
    }

    @XmlElementWrapper(name="categoryList", nillable = true)
    @XmlElement(name = "category")
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addCategoryToTypeMenu(Category category){
        categoryList.add(category);
    }

    public int getSizeCategory(){
        return categoryList.size();
    }


}
