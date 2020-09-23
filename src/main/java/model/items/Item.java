package model.items;


import model.AbstractBaseEntity;
import model.items.seo.SeoMetaData;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "items")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "items_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
//    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
@NamedQueries({
        @NamedQuery(name = Item.DELETE, query = "DELETE FROM Item i WHERE i.id=:id"),
        @NamedQuery(name = Item.GET_ALL, query = "SELECT  i FROM Item i LEFT JOIN i.seoMetaData smd " +
                "LEFT JOIN  i.brand b  LEFT JOIN  i.mesure m LEFT JOIN i.category c " +
                "ORDER BY i.title"),
        @NamedQuery(name = Item.COUNT_ALL, query = "SELECT count(i.id) FROM Item i"),
        @NamedQuery(name = Item.COUNT_FILTER, query = "SELECT count(i.id) FROM Item i")
})
@DynamicUpdate
public class Item extends AbstractBaseEntity {

    public static final String DELETE = "Delete item";
    public static final String GET_ALL = "Get all items";
    public static final String GET_FILTER = "Get filter items";
    public static final String COUNT_ALL = "Count all items";
    public static final String COUNT_FILTER = "Count filter items";


    public static final String NAMED_FILTER_QUERY = "SELECT  i FROM Item i LEFT JOIN i.seoMetaData smd " +
            "LEFT JOIN  i.brand b  LEFT JOIN  i.mesure m LEFT JOIN i.category c ";

    public static final String NAMED_FILTER_COUNT_QUERY = "SELECT count(i.id)  FROM Item i LEFT JOIN i.seoMetaData smd " +
            "LEFT JOIN  i.brand b  LEFT JOIN  i.mesure m LEFT JOIN i.category c ";


    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description")

    private String description;

    @Column(name = "url_seo")
    private String seoUrl;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mesure_id")
    private ItemMesure mesure;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "partnumber")
    private String partnumber;

    @Column(name = "weight")
    private BigDecimal weight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="brend_id")
    private ItemBrand brand;


  //  @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private ItemCategory category;


    @Column(name = "activity")
    private boolean activity;

    @Column(name = "sales_hit")
    private boolean salesHit;

    @Column(name = "new_item")
    private boolean newItem;

    @Column(name = "promotion")
    private boolean promotion;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SeoMetaData seoMetaData;


    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.EAGER, mappedBy = "item", orphanRemoval=true)
    private List<ItemImage> images;


    public Item() {

    }

    public Item(Integer id, @NotBlank String title, String shortDescription, String description, String seoUrl, BigDecimal price, Integer quantity, ItemMesure mesure, BigDecimal discount, String partnumber, BigDecimal weight, ItemBrand brand, ItemCategory category, boolean activity, boolean salesHit, boolean newItem, boolean promotion, SeoMetaData seoMetaData, List<ItemImage> images) {
        super(id);
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.seoUrl = seoUrl;
        this.price = price;
        this.quantity = quantity;
        this.mesure = mesure;
        this.discount = discount;
        this.partnumber = partnumber;
        this.weight = weight;
        this.brand = brand;
        this.category = category;
        this.activity = activity;
        this.salesHit = salesHit;
        this.newItem = newItem;
        this.promotion = promotion;
        this.seoMetaData = seoMetaData;
        this.images = images;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return shortDescription;
    }

    public void setShort_description(String short_description) {
        this.shortDescription = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemMesure getMesure() {
        return mesure;
    }

    public void setMesure(ItemMesure mesure) {
        this.mesure = mesure;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public ItemBrand getBrand() {
        return brand;
    }

    public void setBrand(ItemBrand brand) {
        this.brand = brand;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public boolean isSalesHit() {
        return salesHit;
    }

    public void setSalesHit(boolean salesHit) {
        this.salesHit = salesHit;
    }

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public SeoMetaData getSeoMetaData() {
        return seoMetaData;
    }

    public void setSeoMetaData(SeoMetaData seoMetaData) {
        this.seoMetaData = seoMetaData;
    }

    public List<ItemImage> getImages() {
        return images;
    }

    public void setImages(List<ItemImage> images) {
        this.images = images;
    }
    public void addImages(List<ItemImage> images) {

        for (ItemImage itemImage: images) {
            itemImage.setItem(this);
        }
        this.images = images;
    }

}
