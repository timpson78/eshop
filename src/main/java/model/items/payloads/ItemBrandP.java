package model.items.payloads;

import model.AbstractBaseEntity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = ItemBrandP.GET_ALL, query = "SELECT i FROM ItemBrandP i ORDER BY i.name")
})


@Entity
@Table(name = "item_brends")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_brand_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemBrandP extends AbstractBaseEntity{

    public static final String GET_ALL= "get all brends";

    @Column(name = "name")
    private String name;


    public ItemBrandP() {
        this.name = name;
    }

    public ItemBrandP(String name) {
        this.name = name;
    }

    public ItemBrandP(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
