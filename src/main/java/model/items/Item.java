package model.items;


import model.AbstractBaseEntity;
import model.seo.SeoMetaData;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@SequenceGenerator(name = "my_seq_gen", sequenceName = "items_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
//    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
@DynamicUpdate
public class Item extends AbstractBaseEntity {

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "description")
    private String description;

    @Column(name = "url_seo")
    private String urlSeo;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mesure_id")
    private ItemMesure mesure;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "partnumber")
    private String partnumber;

    @Column(name = "weight")
    private BigDecimal weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="brend_id")
    private ItemBrand brand;

    @OneToOne(fetch = FetchType.EAGER)
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
    @JoinColumn(name="meta_data_id")
    private SeoMetaData seoMetaData;


    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "id")
    private List<ItemImage> images;

    public Item() {

    }

    public Item( Integer id, @NotBlank String title, String short_description, String description, List<ItemImage> images, String urlSeo, BigDecimal price, Integer quantity, ItemMesure mesure, Integer discount, String partnumber, BigDecimal weight, ItemBrand brand, ItemCategory category, boolean activity, boolean salesHit, boolean newItem, boolean promotion, SeoMetaData seoMetaData) {
        super(id);
        this.title = title;
        this.short_description = short_description;
        this.description = description;
        this.images = images;
        this.urlSeo = urlSeo;
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
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlSeo() {
        return urlSeo;
    }

    public void setUrlSeo(String urlSeo) {
        this.urlSeo = urlSeo;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
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
