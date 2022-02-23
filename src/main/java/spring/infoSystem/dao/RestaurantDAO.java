package spring.infoSystem.dao;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultDocument;
import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
//import spring.infoSystem.Parser.SaxMyParser;
import spring.infoSystem.model.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RestaurantDAO {

//    private List<TypeMenu> typeMenuList;
//
//    {
//        typeMenuList = new ArrayList<>();
//
//        Dish dish11 = new Dish("Mushroom soup","Soups","some consist", 273.2, 350.3, 12.5);
//        Dish dish12 = new Dish("Cream-Soup","Soups","some consist", 124, 312, 17.0);
//
//        Dish dish21 = new Dish("Mashed potatoes", "Hot Appetizers","some consist", 256, 55, 11.9);
//        Dish dish22 = new Dish("Fried cheese", "Hot Appetizers","some consist", 346, 124, 23.2);
//
//        Dish dish31 = new Dish("SHRIMPS IN TOM-YAM SAUCE", "Snacks","some consist", 1202, 832, 25.5);
//        Dish dish32 = new Dish("Rolls Tinatika", "Snacks","some consist", 993, 323, 25.5);
//
//        Drink barCard1 = new Drink("Americano", "Coffee", 0, 0.25, 0.5);
//        Drink barCard2 = new Drink("Late", "Coffee", 0, 0.25, 0.5);
//        Drink barCard3 = new Drink("Corona Extra", "Beer", 4.5, 0.5, 1);
//
//        Category category1 = new Category("Menu","Soups");
//        Category category2 = new Category("Menu","Hot Appetizers");
//        Category category3 = new Category("Menu","Snacks");
//        Category category4 = new Category("BarCard", "Coffee");
//        Category category5 = new Category("BarCard", "Beer");
//
//        TypeMenu typeMenu1 = new TypeMenu("Menu");
//        TypeMenu typeMenu2 = new TypeMenu("BarCard");
//
//        category1.addDishToCategory(dish11);
//        category1.addDishToCategory(dish12);
//
//        category2.addDishToCategory(dish21);
//        category2.addDishToCategory(dish22);
//
//        category3.addDishToCategory(dish31);
//        category3.addDishToCategory(dish32);
//
//        category4.addDrinkToCategory(barCard1);
//        category4.addDrinkToCategory(barCard2);
//
//        category5.addDrinkToCategory(barCard3);
//
//        typeMenu1.addCategoryToTypeMenu(category1);
//        typeMenu1.addCategoryToTypeMenu(category2);
//        typeMenu1.addCategoryToTypeMenu(category3);
//
//        typeMenu2.addCategoryToTypeMenu(category4);
//        typeMenu2.addCategoryToTypeMenu(category5);
//
//        typeMenuList.add(typeMenu1);
//        typeMenuList.add(typeMenu2);
//
//    }
//
//    public List<TypeMenu> showTypeMenu(){
//        return typeMenuList;
//    }
//
//    public List<Category> showListCategory(){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .collect(Collectors.toList());
//    }
//
//    public List<Category> showListFromType(String name){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .filter(category -> Objects.equals(category.getNameTypeMenu(), name))
//                .collect(Collectors.toList());
//    }
//
//    public List<Dish> showListAllDish(){
//        return typeMenuList.stream().flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getDishList().stream())
//                .collect(Collectors.toList());
//    }
//
//    public List<Dish> getListDishFromCategory(String name){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getDishList().stream())
//                .filter(dish -> Objects.equals(dish.getNameCategory(), name))
//                .collect(Collectors.toList());
//    }
//
//    public List<Drink> getBarCard(){
//        return typeMenuList.stream().flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getBarCards().stream())
//                .collect(Collectors.toList());
//    }
//
//    public List<Drink> getBarCardFromCategory(String name){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getBarCards().stream())
//                .filter(barCard -> Objects.equals(barCard.getNameCategory(), name))
//                .collect(Collectors.toList());
//    }
//
//    public void insertCategory(Category category){
//        for (TypeMenu typeMenu : typeMenuList){
//            if (typeMenu.getNameTypeMenu().equals(category.getNameTypeMenu())){
//                typeMenu.addCategoryToTypeMenu(category);
//            }
//        }
//    }
//
//    public void insertDish(Dish dish){
//        for (TypeMenu typeMenu: typeMenuList){
//            for (Category category : typeMenu.getCategoryList()){
//                if (category.getNameCategory().equals(dish.getNameCategory())){
//                    category.addDishToCategory(dish);
//                }
//            }
//        }
//    }
//
//    public void insertDrink(Drink drink){
//        for (TypeMenu typeMenu: typeMenuList){
//            for (Category category : typeMenu.getCategoryList()){
//                if (category.getNameCategory().equals(drink.getNameCategory())){
//                    category.addDrinkToCategory(drink);
//                }
//            }
//        }
//    }
//
//    public void deleteDish(String name){
//        for (TypeMenu typeMenu : typeMenuList){
//            for (Category category : typeMenu.getCategoryList()){
//                category.getDishList().removeIf(x -> Objects.equals(x.getNameDish(), name));
//            }
//        }
//    }
//
//    public void deleteDrink(String name){
//        for (TypeMenu typeMenu : typeMenuList){
//            for (Category category : typeMenu.getCategoryList()){
//                category.getBarCards().removeIf(x -> Objects.equals(x.getNameDrink(), name));
//            }
//        }
//    }
//
//    public void deleteCategory(String nameCategory){
//        //categories.removeIf(c -> c.getNameCategory().equals(nameCategory));
//        for (TypeMenu typeMenu : typeMenuList){
//            typeMenu.getCategoryList().removeIf(c -> c.getNameCategory().equals(nameCategory));
//        }
//    }
//
//
//
//    public Dish getDishInfoFromMenu(String name){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getDishList().stream())
//                .filter(dish -> Objects.equals(dish.getNameDish(), name))
//                .findAny().orElse(null);
//    }
//
//    public Drink getDrinkInfoFromBarCard(String name){
//        return typeMenuList.stream()
//                .flatMap(typeMenu -> typeMenu.getCategoryList().stream())
//                .flatMap(category -> category.getBarCards().stream())
//                .filter(barCard -> Objects.equals(barCard.getNameDrink(), name))
//                .findAny().orElse(null);
//    }
//
//    public void updateDish(String name, Dish dish){
//        Dish dishInfo = getDishInfoFromMenu(name);
//        dishInfo.setConsistDish(dish.getConsistDish());
//        dishInfo.setCalories(dish.getCalories());
//        dishInfo.setWeight(dish.getWeight());
//        dishInfo.setPrice(dish.getPrice());
//    }
//
//    public void updateDrink(String name, Drink drink){
//        Drink newDrink = getDrinkInfoFromBarCard(name);
//        newDrink.setFortressDrink(drink.getFortressDrink());
//        newDrink.setSizeDrink(drink.getSizeDrink());
//        newDrink.setPriceDrink(drink.getPriceDrink());
//    }
//
//    public List<CheckIn> searchAll(String search){
//        List<CheckIn> dishes = new ArrayList<>();
//        for (TypeMenu typeMenu : typeMenuList){
//            for (Category category : typeMenu.getCategoryList()){
//                category.getBarCards().stream().filter(x -> x.getNameDrink().toUpperCase().trim().contains(search.toUpperCase().trim()) ||
//                        x.getNameCategory().contains(search)).forEach(dishes::add);
//                category.getDishList().stream().filter(x -> x.getNameDish().toUpperCase().trim().contains(search.toUpperCase().trim()) ||
//                        x.getNameCategory().contains(search)).forEach(dishes::add);
//            }
//        }
//        return dishes;
//    }
//
//    public void saveData() throws IOException, ParserConfigurationException, TransformerException, XMLStreamException {
//        /*FileOutputStream file =  new FileOutputStream("data.txt");
//        ObjectOutputStream out = new ObjectOutputStream(file);
//        out.writeObject(typeMenuList);
//        out.close();*/
//        XMLOutputFactory factory1 = XMLOutputFactory.newFactory();
//        XMLStreamWriter writer =  factory1.createXMLStreamWriter(new FileOutputStream("temp1.xml"));
//
//
//
//        writer.writeStartDocument();
//        writer.writeStartElement("typeMenuList");
//        writer.writeStartElement("typeMenu");
//        writer.writeStartElement("nameTypeMenu");
//        writer.writeCharacters("Menu");
//        writer.writeEndElement();
//
//        writer.writeStartElement("categoryList");
//        for(int i = 0; i < typeMenuList.get(0).getSizeCategory(); i++) {
//            writer.writeStartElement("element");
//
//            writer.writeStartElement("nameTypeMenu");
//            writer.writeCharacters("Menu");
//            writer.writeEndElement();
//            writer.writeStartElement("nameCategory");
//            writer.writeCharacters(typeMenuList.get(0).getCategoryList().get(i).getNameCategory());
//            writer.writeEndElement();
//
//            writer.writeStartElement("dishList");
//            for(int j = 0; j < typeMenuList.get(0).getCategoryList().get(i).getDishList().size(); j++) {
//                writer.writeStartElement("elementDish");
//
//                writer.writeStartElement("nameDish");
//                writer.writeCharacters(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getNameDish());
//                writer.writeEndElement();
//                writer.writeStartElement("nameCategory");
//                writer.writeCharacters(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getNameCategory());
//                writer.writeEndElement();
//                writer.writeStartElement("consistDish");
//                writer.writeCharacters(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getConsistDish());
//                writer.writeEndElement();
//                writer.writeStartElement("calories");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getCalories()));
//                writer.writeEndElement();
//                writer.writeStartElement("weight");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getWeight()));
//                writer.writeEndElement();
//                writer.writeStartElement("price");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(0).getCategoryList().get(i).getDishList().get(j).getPrice()));
//                writer.writeEndElement();
//
//                writer.writeEndElement(); // </elementDish>
//            }
//            writer.writeEndElement(); // </dishList>
//
//            writer.writeEndElement(); // </element>
//        }
//        writer.writeEndElement(); // </categoryList>
//
//        writer.writeEndElement(); // </typeMenu>
//        writer.writeStartElement("typeMenuBar");
//
//        writer.writeStartElement("nameTypeMenu");
//        writer.writeCharacters("BarCard");
//        writer.writeEndElement();
//
//        writer.writeStartElement("categoryList");
//        for(int i = 0; i < typeMenuList.get(1).getSizeCategory(); i++) {
//            writer.writeStartElement("elementDrinkList");
//
//            writer.writeStartElement("nameTypeMenu");
//            writer.writeCharacters("BarCard");
//            writer.writeEndElement();
//            writer.writeStartElement("nameCategory");
//            writer.writeCharacters(typeMenuList.get(1).getCategoryList().get(i).getNameCategory());
//            writer.writeEndElement();
//
//            writer.writeStartElement("barCards");
//            for(int j = 0; j < typeMenuList.get(1).getCategoryList().get(i).getBarCards().size(); j++) {
//                writer.writeStartElement("elementDrink");
//
//                writer.writeStartElement("nameDrink");
//                writer.writeCharacters(typeMenuList.get(1).getCategoryList().get(i).getBarCards().get(j).getNameDrink());
//                writer.writeEndElement();
//                writer.writeStartElement("nameCategory");
//                writer.writeCharacters(typeMenuList.get(1).getCategoryList().get(i).getBarCards().get(j).getNameCategory());
//                writer.writeEndElement();
//                writer.writeStartElement("fortressDrink");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(1).getCategoryList().get(i).getBarCards().get(j).getFortressDrink()));
//                writer.writeEndElement();
//                writer.writeStartElement("sizeDrink");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(1).getCategoryList().get(i).getBarCards().get(j).getSizeDrink()));
//                writer.writeEndElement();
//                writer.writeStartElement("priceDrink");
//                writer.writeCharacters(String.valueOf(typeMenuList.get(1).getCategoryList().get(i).getBarCards().get(j).getPriceDrink()));
//                writer.writeEndElement();
//
//                writer.writeEndElement(); // </elementDrink>
//            }
//            writer.writeEndElement(); // </barCards>
//
//            writer.writeEndElement(); // </elementDrinkList>
//        }
//        writer.writeEndElement(); // </categoryList>
//
//        writer.writeEndElement();
//
//
//        writer.writeEndElement();
//        writer.writeEndDocument();
//        writer.flush();
//
//
//    }
//    public void uploadData() throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
//        /*try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
//            typeMenuList = (List<TypeMenu>) in.readObject();
//            in.close();
//        }
//        catch(FileNotFoundException ex){
//
//        }*/
//        SaxMyParser saxMyParser = new SaxMyParser();
//        typeMenuList = saxMyParser.getParseList();
//    }

}
