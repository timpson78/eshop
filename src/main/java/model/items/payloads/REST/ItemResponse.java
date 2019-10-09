package model.items.payloads.REST;

import model.items.Item;

public class ItemResponse {

    private Item item;

    private Integer itemCategoryId;

    private Integer mesureId;

    private Integer itemBrandId;


    public ItemResponse(Item item, Integer itemCategoryId, Integer mesureId, Integer itemBrandId) {
        this.item = item;
        this.itemCategoryId = itemCategoryId;
        this.mesureId = mesureId;
        this.itemBrandId = itemBrandId;

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Integer getMesureId() {
        return mesureId;
    }

    public void setMesureId(Integer mesureId) {
        this.mesureId = mesureId;
    }

    public Integer getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Integer itemBrandId) {
        this.itemBrandId = itemBrandId;
    }


}
