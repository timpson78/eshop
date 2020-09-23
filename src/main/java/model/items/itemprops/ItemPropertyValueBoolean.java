package model.items.itemprops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_property_values_boolean")
public class ItemPropertyValueBoolean extends AbstractBaseEntity{

    @Column(name = "value")
    private boolean value;

    @OneToOne(mappedBy = "booleanValue", cascade = CascadeType.ALL)
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id")
    private ItemPropertyValue itemPropertyValue;

    public ItemPropertyValueBoolean() {

    }

    public ItemPropertyValueBoolean(boolean value, ItemPropertyValue itemPropertyValue) {
        this.value = value;
        this.itemPropertyValue = itemPropertyValue;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public ItemPropertyValue getItemPropertyValue() {
        return itemPropertyValue;
    }

    public void setItemPropertyValue(ItemPropertyValue itemPropertyValue) {
        this.itemPropertyValue = itemPropertyValue;
    }
}
