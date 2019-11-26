package model.items.itemprops;

import model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.List;



@NamedQueries({
        @NamedQuery(name = ItemPropertyValueType.GET_ALL, query = "SELECT i FROM ItemPropertyValueType i"),
})

@Entity
@Table(name = "item_properties_value_type")
public class ItemPropertyValueType extends AbstractBaseEntity {

    public final static String GET_ALL = "get all properties types";

    @Column(name = "name")
    private String name;

    @Column(name = "aliasname")
    private String aliasName;


    public ItemPropertyValueType() {

    }


    public ItemPropertyValueType(String name, String aliasName) {
        this.name = name;
        this.aliasName = aliasName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
}


