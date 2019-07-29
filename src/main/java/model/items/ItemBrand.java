package model.items;

import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_brends")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_brand_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemBrand extends AbstractBaseEntity {

    @OneToOne(mappedBy = "brand")
    private  Item item;

    @Column(name = "name")
    private String name;

    public ItemBrand() {}

    public ItemBrand(Integer id,  String name) {
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
