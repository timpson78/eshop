package model.items.payloads;

import model.AbstractBaseEntity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = ItemImageP.DELETE, query = "DELETE FROM ItemImageP  ii WHERE ii.id = :id and ii.itemId = :itemId")
})


@Entity
@Table(name = "item_images")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_images_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemImageP extends AbstractBaseEntity {

    public static final String DELETE = "delete image from table";

    @Column(name = "fk_item_id")
    private Integer itemId;


    @Column(name = "src")
    private String src;



    public ItemImageP(Integer id, int itemId, String src) {
        super(id);
        this.itemId = itemId;
        this.src = src;
    }
    public ItemImageP(){

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


}
