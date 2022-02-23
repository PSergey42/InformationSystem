//package spring.infoSystem.Parser;
//
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//import spring.infoSystem.model.Category;
//import spring.infoSystem.model.Dish;
//import spring.infoSystem.model.Drink;
//import spring.infoSystem.model.TypeMenu;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SaxParserHandler extends DefaultHandler {
//
//    private List<TypeMenu> typeMenuList = new ArrayList<>();
//
//    //TypeMenu
//    private static final String TAG_CATEGORY_LIST = "categoryList";
//
//    //TypeMenu && Category
//    private static final String TAG_NAME_TYPE_MENU = "nameTypeMenu";
//
//    //Dish
//    private static final String TAG_NAME_DISH = "nameDish";
//    private static final String TAG_CONSIST_DISH = "consistDish";
//    private static final String TAG_CALORIES = "calories";
//    private static final String TAG_WEIGHT = "weight";
//    private static final String TAG_PRICE = "price";
//
//    //Dish && Drink && Category
//    private static final String TAG_NAME_CATEGORY = "nameCategory";
//
//    //Drink
//    private static final String TAG_NAME_DRINK = "nameDrink";
//    private static final String TAG_FORTRESS_DRINK = "fortressDrink";
//    private static final String TAG_SIZE_DRINK = "sizeDrink";
//    private static final String TAG_PRICE_DRINK = "priceDrink";
//
//    //Category
//    private static final String TAG_BAR_CARDS = "barCards";
//    private static final String TAG_DISH_LIST = "dishList";
//
//    private String currentTagName;
//
//    private static final String TAG_ELEMENT = "element";
//    private static final String TAG_ELEMENT_DISH = "elementDish";
//    private static final String TAG_ELEMENT_DRINK = "elementDrink";
//    private static final String TAG_TYPE_MENU = "typeMenu";
//    private static final String TAG_TYPE_MENU_BAR = "typeMenuBar";
//    private static final String TAG_ELEMENT_DRINK_LIST = "elementDrinkList";
//
//    private boolean isCategory = false;
//    private boolean isDrink = false;
//    private boolean isDish = false;
//    private boolean isElement = false;
//    private boolean isElementDish = false;
//    private boolean isElementDrink = false;
//    private boolean isTypeMenu = false;
//    private boolean isTypeMenuBar = false;
//    private boolean elementDrinkList = false;
//
//    //TypeMenu
//    private String nameTypeMenu;
//    private List<Category> categoryList = new ArrayList<>();
//
//    //Category
//    private String nameCategory;
//    private List<Drink> barCards = new ArrayList<>();
//    private List<Dish> dishList = new ArrayList<>();
//
//    //Dish
//    private String nameDish;
//    private String consistDish;
//    private double calories;
//    private double weight;
//    private double price;
//
//    //Drink
//    String nameDrink;
//    double fortressDrink;
//    double sizeDrink;
//    double priceDrink;
//
//    @Override
//    public void startDocument() throws SAXException {
//
//    }
//
//    @Override
//    public void endDocument() throws SAXException {
//        SaxMyParser.setTypeMenuList(typeMenuList);
//    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        currentTagName = qName;
//        switch (currentTagName){
//            case TAG_CATEGORY_LIST: {
//                isCategory = true;
//                break;
//            }
//            case TAG_DISH_LIST: {
//                isDish = true;
//                break;
//            }
//            case TAG_BAR_CARDS: {
//                isDrink = true;
//                break;
//            }
//            case TAG_ELEMENT: {
//                isElement = true;
//                break;
//            }
//            case TAG_TYPE_MENU: {
//                isTypeMenu = true;
//                break;
//            }
//            case TAG_ELEMENT_DISH: {
//                isElementDish = true;
//                break;
//            }
//            case TAG_ELEMENT_DRINK: {
//                isElementDrink = true;
//                break;
//            }
//            case TAG_TYPE_MENU_BAR: {
//                isTypeMenuBar = true;
//                break;
//            }
//            case TAG_ELEMENT_DRINK_LIST: {
//                elementDrinkList = true;
//                break;
//            }
//
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        currentTagName = null;
//        switch (qName){
//            case TAG_CATEGORY_LIST: {
//                isCategory = false;
//                break;
//            }
//            case TAG_DISH_LIST: {
//                isDish = false;
//                break;
//            }
//            case TAG_BAR_CARDS: {
//                isDrink = false;
//                break;
//            }
//            case TAG_ELEMENT: {
//                isElement = false;
//                Category category = new Category(nameTypeMenu, nameCategory);
//                category.setDishList(dishList);
//                dishList = new ArrayList<>();
//                categoryList.add(category);
//                break;
//            }
//            case TAG_TYPE_MENU: {
//                isTypeMenu = false;
//                TypeMenu typeMenu = new TypeMenu(nameTypeMenu);
//                typeMenu.setCategoryList(categoryList);
//                categoryList = new ArrayList<>();
//                typeMenuList.add(typeMenu);
//                break;
//            }
//            case TAG_ELEMENT_DISH: {
//                isElementDish = false;
//                dishList.add(new Dish(nameDish, nameCategory, consistDish,
//                        calories, weight, price));
//                break;
//            }
//            case TAG_ELEMENT_DRINK: {
//                isElementDrink = false;
//                barCards.add(new Drink(nameDrink, nameCategory, fortressDrink,
//                        sizeDrink, priceDrink));
//                break;
//            }
//            case TAG_TYPE_MENU_BAR: {
//                isTypeMenuBar = false;
//                TypeMenu typeMenu = new TypeMenu(nameTypeMenu);
//                typeMenu.setCategoryList(categoryList);
//                categoryList = new ArrayList<>();
//                typeMenuList.add(typeMenu);
//                break;
//            }
//            case TAG_ELEMENT_DRINK_LIST: {
//                elementDrinkList = false;
//                Category category = new Category(nameTypeMenu, nameCategory);
//                category.setBarCards(barCards);
//                barCards = new ArrayList<>();
//                categoryList.add(category);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        if(currentTagName == null) return;
//        if (isTypeMenu) {
//            if (currentTagName.equals(TAG_NAME_TYPE_MENU)) nameTypeMenu = new String(ch, start, length);
//            else if (isCategory && isElement) {
//                if (currentTagName.equals(TAG_NAME_CATEGORY)) nameCategory = new String(ch, start, length);
//                else if (isDish && isElementDish) {
//                    switch (currentTagName) {
//                        case TAG_NAME_DISH: {
//                            nameDish = new String(ch, start, length);
//                            break;
//                        }
//                        case TAG_CONSIST_DISH: {
//                            consistDish = new String(ch, start, length);
//                            break;
//                        }
//                        case TAG_CALORIES: {
//                            calories = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                        case TAG_NAME_CATEGORY: {
//                            nameCategory = new String(ch, start, length);
//                            break;
//                        }
//                        case TAG_WEIGHT: {
//                            weight = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                        case TAG_PRICE: {
//                            price = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                    }
//                }
//            }
//        } else if (isTypeMenuBar) {
//            if (currentTagName.equals(TAG_NAME_TYPE_MENU)) nameTypeMenu = new String(ch, start, length);
//            else if (isCategory && elementDrinkList) {
//                if (currentTagName.equals(TAG_NAME_CATEGORY)) nameCategory = new String(ch, start, length);
//                else if (isDrink && isElementDrink) {
//                    switch (currentTagName) {
//                        case TAG_NAME_DRINK: {
//                            nameDrink = new String(ch, start, length);
//                            break;
//                        }
//                        case TAG_FORTRESS_DRINK: {
//                            fortressDrink = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                        case TAG_SIZE_DRINK: {
//                            sizeDrink = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                        case TAG_PRICE_DRINK: {
//                            priceDrink = Double.parseDouble(new String(ch, start, length));
//                            break;
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//
//}
