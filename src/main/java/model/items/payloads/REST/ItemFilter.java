package model.items.payloads.REST;

import java.math.BigDecimal;

public class ItemFilter {

    private String partnumber;

    private String title;

    private Integer brandId;

    private Integer categoryId;

    private BigDecimal priceIn;

    private BigDecimal priceOut;

    private Boolean newItem;

    private Boolean activity;

    private Boolean saleshit;

    private Boolean promotion;

    public ItemFilter() {

    }

    public ItemFilter(String partnumber, String title, Integer brandId, Integer categoryId, BigDecimal priceIn, BigDecimal priceOut, Boolean newItem, Boolean activity, Boolean saleshit, Boolean promotion) {
        this.partnumber = partnumber;
        this.title = title;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.newItem = newItem;
        this.activity = activity;
        this.saleshit = saleshit;
        this.promotion = promotion;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(BigDecimal priceIn) {
        this.priceIn = priceIn;
    }

    public BigDecimal getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(BigDecimal priceOut) {
        this.priceOut = priceOut;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public Boolean getSaleshit() {
        return saleshit;
    }

    public void setSaleshit(Boolean saleshit) {
        this.saleshit = saleshit;
    }

    public Boolean getNewItem() {
        return newItem;
    }

    public void setNewItem(Boolean newItem) {
        this.newItem = newItem;
    }

    public Boolean getPromotion() {
        return promotion;
    }

    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }
}
