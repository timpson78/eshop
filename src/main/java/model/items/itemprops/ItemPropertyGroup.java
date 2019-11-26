package model.items.itemprops;

import model.AbstractBaseEntity;
import javax.persistence.*;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = ItemPropertyGroup.DELETE, query = "DELETE FROM ItemPropertyGroup i WHERE i.id=:id"),
        @NamedQuery(name = ItemPropertyGroup.GET_ALL, query = "SELECT i FROM ItemPropertyGroup i"),
        @NamedQuery(name = ItemPropertyGroup.DELETE_LIST, query = "DELETE  FROM ItemPropertyGroup i WHERE i.id IN (:ids)")
})


@Entity
@Table(name = "item_property_groups")
public class ItemPropertyGroup extends AbstractBaseEntity {


    public final static String DELETE = "Delete property group";
    public final static String DELETE_LIST = "Delete many properties groups";
    public final static String GET_ALL = "Get all property group";

    private String name;

    public ItemPropertyGroup() {

    }

    public ItemPropertyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
