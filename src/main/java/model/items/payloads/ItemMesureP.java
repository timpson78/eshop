package model.items.payloads;


import model.AbstractBaseEntity;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = ItemMesureP.GET_ALL, query = "FROM ItemMesureP im")

})


@Entity
@Table(name = "item_mesures")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_mesures_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemMesureP extends  AbstractBaseEntity{

    public final static String GET_ALL = "Get All  mesures from table";


    public ItemMesureP() {
    }

    public ItemMesureP(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;



}
