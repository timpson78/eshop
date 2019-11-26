package model.items.itemprops;

import model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "item_common_properties")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_common_properties_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)

@NamedQueries({
        @NamedQuery(name = ItemCommonProperty.GET_ALL, query = "SELECT i FROM ItemCommonProperty i  WHERE i.propertyGroup.id=:groupId"),
        @NamedQuery(name = ItemCommonProperty.DELETE, query = "DELETE FROM ItemCommonProperty i  WHERE i.id=:id"),
        @NamedQuery(name = ItemCommonProperty.DELETE_ALL_GROUP, query = "DELETE FROM ItemCommonProperty i  WHERE i.propertyGroup.id IN (:ids)")
})

public class ItemCommonProperty extends AbstractBaseEntity {


    public final static String GET_ALL = "Get all item common properties ";
    public final static String DELETE = "Delete item common property";
    public final static String DELETE_ALL_GROUP = "Delete all group of items common properties";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_property_group_id")
    private ItemPropertyGroup propertyGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_property_value_type_id")
    private ItemPropertyValueType valueType;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;


    @Column(name = "mesure")
    private String mesure;

    public ItemCommonProperty(){

    }

    public ItemCommonProperty(ItemPropertyGroup propertyGroup, ItemPropertyValueType valueType, String name, String description, String mesure) {
        this.propertyGroup = propertyGroup;
        this.valueType = valueType;
        this.name = name;
        this.description = description;
        this.mesure = mesure;
    }

    public ItemPropertyGroup getPropertyGroup() {
        return propertyGroup;
    }

    public void setPropertyGroup(ItemPropertyGroup propertyGroup) {
        this.propertyGroup = propertyGroup;
    }

    public ItemPropertyValueType getValueType() {
        return valueType;
    }

    public void setValueType(ItemPropertyValueType valueType) {
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }
}
