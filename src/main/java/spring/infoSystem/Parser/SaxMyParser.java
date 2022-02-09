package spring.infoSystem.Parser;

import org.xml.sax.SAXException;
import spring.infoSystem.model.TypeMenu;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxMyParser {
    private static List<TypeMenu> typeMenuList;

    public SaxMyParser(){
        typeMenuList = new ArrayList<>();
    }

    public List<TypeMenu> getParseList() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser saxParser = saxParserFactory.newSAXParser(); //iskl

        saxParser.parse(new File("test.xml"),handler);

        return getTypeMenuList();
    }

    public List<TypeMenu> getTypeMenuList(){
        return typeMenuList;
    }

    public static void setTypeMenuList(List<TypeMenu> typeMenuList){
        SaxMyParser.typeMenuList = typeMenuList;
    }
}
