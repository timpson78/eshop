package model.items.itemprops;


import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_property_values_list")
public class ItemPropertyValueList extends AbstractBaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_item_property_value_id")
    @JsonIgnore
    private ItemPropertyValue itemPropertyValue;


    @Column(name = "value")
    private int value;

    @Column(name = "active")
    private int active;

    public ItemPropertyValueList() {

    }
    public ItemPropertyValueList(ItemPropertyValue itemPropertyValue, int value, int active) {
        this.itemPropertyValue = itemPropertyValue;
        this.value = value;
        this.active = active;
    }

    public ItemPropertyValue getItemPropertyValue() {
        return itemPropertyValue;
    }

    public void setItemPropertyValue(ItemPropertyValue itemPropertyValue) {
        this.itemPropertyValue = itemPropertyValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
