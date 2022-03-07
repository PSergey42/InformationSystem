package spring.infoSystem.Parser;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import spring.infoSystem.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbWorker {

    private TypeMenuAll typeMenus = new TypeMenuAll();

    public JaxbWorker(){

    }

    public JaxbWorker(List<TypeMenu> typeMenus){
        this.typeMenus.setTypeMenus(typeMenus);
    }


    // восстанавливаем объект из XML файла
    public static List<TypeMenu> fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Drink.class, Dish.class, Category.class, TypeMenu.class, TypeMenuAll.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return ((TypeMenuAll)un.unmarshal(new File(filePath))).getTypeMenus();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    public void convertDishOrDrinkToXml(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Drink.class, Dish.class, Category.class, TypeMenu.class, TypeMenuAll.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(typeMenus, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
