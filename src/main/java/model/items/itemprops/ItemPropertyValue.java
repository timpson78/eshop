package model.items.itemprops;


import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;
import model.items.seo.SeoMetaData;

import javax.persistence.*;

@Entity
@Table(name = "item_property_values")
public class ItemPropertyValue extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_common_property_id")
    @JsonIgnore
    private ItemCommonProperty itemCommonProperty;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueInteger IntegerValue;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueBoolean BooleanValue;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ItemPropertyValueString StringValue;

    public ItemPropertyValue() {

    }

    public ItemPropertyValue(ItemCommonProperty itemCommonProperty, ItemPropertyValueInteger integerValue, ItemPropertyValueBoolean booleanValue, ItemPropertyValueString stringValue) {
        this.itemCommonProperty = itemCommonProperty;
        IntegerValue = integerValue;
        BooleanValue = booleanValue;
        StringValue = stringValue;
    }

    public ItemCommonProperty getItemCommonProperty() {
        return itemCommonProperty;
    }

    public void setItemCommonProperty(ItemCommonProperty itemCommonProperty) {
        this.itemCommonProperty = itemCommonProperty;
    }

    public ItemPropertyValueInteger getIntegerValue() {
        return IntegerValue;
    }

    public void setIntegerValue(ItemPropertyValueInteger integerValue) {
        IntegerValue = integerValue;
    }

    public ItemPropertyValueBoolean getBooleanValue() {
        return BooleanValue;
    }

    public void setBooleanValue(ItemPropertyValueBoolean booleanValue) {
        BooleanValue = booleanValue;
    }

    public ItemPropertyValueString getStringValue() {
        return StringValue;
    }

    public void setStringValue(ItemPropertyValueString stringValue) {
        StringValue = stringValue;
    }
}
