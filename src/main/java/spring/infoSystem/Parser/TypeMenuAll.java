package spring.infoSystem.Parser;

import spring.infoSystem.model.Drink;
import spring.infoSystem.model.TypeMenu;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TypeMenuAll")
@XmlType(propOrder = {"typeMenus"})
public class TypeMenuAll {

    private List<TypeMenu> typeMenus;

    public TypeMenuAll(){
        typeMenus = new ArrayList<>();
    }

    @XmlElementWrapper(name="types", nillable = true)
    @XmlElement(name = "typeMenu")
    public List<TypeMenu> getTypeMenus() {
        return typeMenus;
    }

    public void setTypeMenus(List<TypeMenu> typeMenus) {
        this.typeMenus = typeMenus;
    }
}
