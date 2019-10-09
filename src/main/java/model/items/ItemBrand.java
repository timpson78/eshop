package model.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_brends")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_brand_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemBrand extends AbstractBaseEntity {

    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "id")
    @JsonIgnore
    private List<Item> items;

    @Column(name = "name")
    private String name;


    public ItemBrand() {}

    public ItemBrand(Integer id,  String name) {
        super(id);
        this.name = name;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
