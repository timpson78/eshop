package model.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "item_mesures")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_mesures_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemMesure extends AbstractBaseEntity {

    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "id")
    @JsonIgnore
    private List<Item> items;


    @Column(name = "name")
    private String name;

    ItemMesure(){

    }


    public ItemMesure(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> item) {
        this.items = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
