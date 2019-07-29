package model.items.payloads;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = ItemCategoryP.GET_ALL_CHILDS, query = "SELECT DISTINCT a FROM ItemCategoryP a LEFT JOIN FETCH a.children  b " +
                "WHERE a.parent.id = :idParent"),
        @NamedQuery(name = ItemCategoryP.GET_ALL_CHILDS_NULL, query = "SELECT DISTINCT a FROM ItemCategoryP a LEFT JOIN FETCH a.children  b " +
                "WHERE a.parent.id is NULL"),
        @NamedQuery(name = ItemCategoryP.GET_ROOT, query = "SELECT DISTINCT a FROM ItemCategoryP a LEFT JOIN FETCH a.children  b " +
                "WHERE a.leftKey=1"),
        @NamedQuery(name = ItemCategoryP.UPDATE_NAME, query = "UPDATE ItemCategoryP SET name = :name WHERE id = :id"),

        @NamedQuery(name = ItemCategoryP.DELETE_BYID, query = "DELETE ItemCategoryP  WHERE id = :id"),

        @NamedQuery(name = ItemCategoryP.DELETE_ALL_CHILDS, query = "DELETE ItemCategoryP  WHERE left_key>:lft and left_key<:rgt")
})

@Entity
@Table(name = "item_categories")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "item_category_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class ItemCategoryP extends AbstractBaseEntity {

    public static final String GET_ALL_CHILDS= "get all childs by parent";
    public static final String GET_ALL_CHILDS_NULL= "get all childs by parent where parent is null";
    public static final String GET_ROOT = "get root node";
    public static final String UPDATE_NAME = "update name of the node";
    public static final String DELETE_BYID = "delete node";
    public static final String DELETE_ALL_CHILDS = "delete all childs node";

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
    private ItemCategoryP parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<ItemCategoryP> children;

    public ItemCategoryP() {
    }

    public ItemCategoryP(String name, Integer leftKey, Integer rightKey, Integer level, ItemCategoryP parent, Set<ItemCategoryP> children) {
        this.name = name;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.level = level;
        this.parent = parent;
        this.children = children;
    }

    public Boolean isLeaf() {
        return this.isInTree() && (this.getRightKey() - this.getLeftKey()) == 1;
    }

    public Boolean isInTree() {
        return this.getLeftKey() > 0 && this.getRightKey() > this.getLeftKey();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ItemCategoryP getParent() {
        return parent;
    }

    public void setParent(ItemCategoryP parent) {
        this.parent = parent;
    }

    public Set<ItemCategoryP> getChildren() {
        return children;
    }

    public void setChildren(Set<ItemCategoryP> children) {
        this.children = children;
    }

}
