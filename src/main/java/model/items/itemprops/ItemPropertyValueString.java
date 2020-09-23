package model.items.itemprops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_property_values_string")
public class ItemPropertyValueString  extends AbstractBaseEntity{

    @Column(name = "value")
    private String value;


    @OneToOne(mappedBy = "stringValue", cascade = CascadeType.ALL)
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id")
    private ItemPropertyValue itemPropertyValue;

    public ItemPropertyValueString() {

    }

    public ItemPropertyValueString(String value, ItemPropertyValue itemPropertyValue) {
        this.value = value;
        this.itemPropertyValue = itemPropertyValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ItemPropertyValue getItemPropertyValue() {
        return itemPropertyValue;
    }

    public void setItemPropertyValue(ItemPropertyValue itemPropertyValue) {
        this.itemPropertyValue = itemPropertyValue;
    }
}
