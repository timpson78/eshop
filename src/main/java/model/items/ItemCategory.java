package model.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import model.AbstractBaseEntity;
import repository.ItemCategoryRepositoryImp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_categories")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_category_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
@NamedQueries({
        @NamedQuery(name = ItemCategory.UPDATE_FIRSTRIGHTKEY, query = "UPDATE ItemCategory SET right_key = right_key + 2 WHERE right_key >= :newRight"),
        @NamedQuery(name = ItemCategory.UPDATE_FIRSTLEFTKEY, query = "UPDATE ItemCategory SET left_key = left_key + 2 WHERE left_key >= :newRight"),
        @NamedQuery(name = ItemCategory.UPDATE_LASTRIGHTKEY, query = "UPDATE ItemCategory SET right_key = right_key + 2 WHERE right_key >= :newLeft"),
        @NamedQuery(name = ItemCategory.UPDATE_LASTLEFTKEY, query = "UPDATE ItemCategory SET left_key = left_key + 2 WHERE left_key > :newLeft"),
        @NamedQuery(name = ItemCategory.GET_ALL_SORTED, query = "FROM ItemCategory  ORDER BY left_key"),
        @NamedQuery(name = ItemCategory.DELETE_BYID, query = "DELETE FROM ItemCategory c WHERE c.id=:id"),
        @NamedQuery(name = ItemCategory.UPDATE_RGTKEY_ON_DELETE, query = "UPDATE ItemCategory SET right_key = right_key - :width WHERE right_key > :right"),
        @NamedQuery(name = ItemCategory.UPDATE_LFTKEY_ON_DELETE, query = "UPDATE ItemCategory SET left_key= left_key - :width WHERE left_key>= :right"),
})


public class ItemCategory extends AbstractBaseEntity {

    public static final String UPDATE_FIRSTRIGHTKEY = "update right keys as first";
    public static final String UPDATE_FIRSTLEFTKEY = "update left keys as first";
    public static final String UPDATE_LASTRIGHTKEY = "update right keys as last";
    public static final String UPDATE_LASTLEFTKEY = "update left keys as last";
    public static final String GET_ALL_SORTED = "get all sorted";
    public static final String DELETE_BYID = "Delete by id";
    public static final String UPDATE_LFTKEY_ON_DELETE = "update left key on delete";
    public static final String UPDATE_RGTKEY_ON_DELETE = "update right key on delete";



    @OneToOne(mappedBy = "category",fetch = FetchType.LAZY)
    private  Item item;

    @Column(name = "name")
    private String name;

    @Column(name = "left_key")
    private Integer leftKey;

    @Column(name = "right_key")
    private Integer rightKey;

    @Column(name = "level")
    private Integer level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private ItemCategory parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ItemCategory> children = new ArrayList<ItemCategory>();

    public ItemCategory() {
    }

    public ItemCategory(Integer id, Integer leftKey, Integer rightKey, Integer level, String name, ItemCategory parent) {
        super(id);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.level = level;
        this.name = name;
        this.parent = parent;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(Integer leftKey) {
        this.leftKey = leftKey;
    }

    public Integer getRightKey() {
        return rightKey;
    }

    public void setRightKey(Integer rightKey) {
        this.rightKey = rightKey;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<ItemCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ItemCategory> children) {
        this.children = children;
    }

    public ItemCategory getParent() {
        return parent;
    }

    public void setParent(ItemCategory parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCategory that = (ItemCategory) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (leftKey != null ? !leftKey.equals(that.leftKey) : that.leftKey != null) return false;
        if (rightKey != null ? !rightKey.equals(that.rightKey) : that.rightKey != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        return children != null ? children.equals(that.children) : that.children == null;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (leftKey != null ? leftKey.hashCode() : 0);
        result = 31 * result + (rightKey != null ? rightKey.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
