package model.items.itemprops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;
import model.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "item_properties")
public class ItemProperty extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_common_property_id")
    private ItemCommonProperty commonProperty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_property_id")
    private ItemPropertyValueType ValueType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_property_value_type_id")
    private ItemPropertyValue Value;

    public ItemProperty() {

    }

    public ItemProperty(Item item, ItemCommonProperty commonProperty, ItemPropertyValueType valueType, ItemPropertyValue value) {
        this.item = item;
        this.commonProperty = commonProperty;
        ValueType = valueType;
        Value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemCommonProperty getCommonProperty() {
        return commonProperty;
    }

    public void setCommonProperty(ItemCommonProperty commonProperty) {
        this.commonProperty = commonProperty;
    }

    public ItemPropertyValueType getValueType() {
        return ValueType;
    }

    public void setValueType(ItemPropertyValueType valueType) {
        ValueType = valueType;
    }

    public ItemPropertyValue getValue() {
        return Value;
    }

    public void setValue(ItemPropertyValue value) {
        Value = value;
    }
}
