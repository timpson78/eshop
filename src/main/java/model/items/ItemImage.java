package model.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_images")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_images_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemImage extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_item_id")
    @JsonIgnore
    private Item item;


    @Column(name = "src")
    private String src;

    public ItemImage(){

    }

    public ItemImage(Integer id, String src) {
        super(id);
        this.src = src;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
