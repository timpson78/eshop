package model.items;

import model.AbstractBaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@Table(name = "item_mesures")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_mesures_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemMesure extends AbstractBaseEntity {

    @OneToOne(mappedBy = "mesure")
    private  Item item;

    @Column(name = "name")
    private String name;

    ItemMesure(){

    }

    public ItemMesure(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
