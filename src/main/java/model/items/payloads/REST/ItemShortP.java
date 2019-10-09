package model.items.payloads.REST;

import java.math.BigDecimal;

public class ItemShortP {

    private String partnumber;

    private String title;

    private Integer quantity;

    private BigDecimal price;

    public ItemShortP() {

    }

    public ItemShortP(String partnumber, String title, Integer quantity, BigDecimal price) {
        this.partnumber = partnumber;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
