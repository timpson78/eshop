package model.items.itemprops;


import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_property_values")
public class ItemPropertyValue extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_common_property_id")
    @JsonIgnore
    private ItemCommonProperty itemCommonProperty;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueInteger integerValue;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueBoolean booleanValue;



    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueString stringValue;

    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "itemPropertyValue")
    //LAZY as Simultaneously Fetch Multiple Bags as Cartesian product
    private List<ItemPropertyValueList> listValues;

    public ItemPropertyValue() {

    }

    public ItemCommonProperty getItemCommonProperty() {
        return itemCommonProperty;
    }

    public void setItemCommonProperty(ItemCommonProperty itemCommonProperty) {
        this.itemCommonProperty = itemCommonProperty;
    }

    public ItemPropertyValueInteger getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(ItemPropertyValueInteger integerValue) {
        this.integerValue = integerValue;
    }

    public ItemPropertyValueBoolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(ItemPropertyValueBoolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public ItemPropertyValueString getStringValue() {
        return stringValue;
    }

    public void setStringValue(ItemPropertyValueString stringValue) {
        this.stringValue = stringValue;
    }

    public List<ItemPropertyValueList> getListValues() {
        return listValues;
    }

    public void setListValues(List<ItemPropertyValueList> listValues) {
        this.listValues = listValues;
    }
}
