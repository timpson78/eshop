package model.items.itemprops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_property_values_integer")
public class ItemPropertyValueInteger extends AbstractBaseEntity{

    @Column(name = "value")
    private int value;

    @OneToOne(mappedBy = "IntegerValue", cascade = CascadeType.ALL)
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id")
    private ItemPropertyValue itemPropertyValue;

    public ItemPropertyValueInteger() {

    }

    public ItemPropertyValueInteger(int value, ItemPropertyValue itemPropertyValue) {
        this.value = value;
        this.itemPropertyValue = itemPropertyValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ItemPropertyValue getItemPropertyValue() {
        return itemPropertyValue;
    }

    public void setItemPropertyValue(ItemPropertyValue itemPropertyValue) {
        this.itemPropertyValue = itemPropertyValue;
    }
}
