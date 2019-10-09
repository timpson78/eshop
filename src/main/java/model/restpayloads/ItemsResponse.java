package model.restpayloads;

import model.items.Item;

import java.util.List;

public class ItemsResponse {

    List<Item> items;

    Long maxPage;

    String message;

    public ItemsResponse(List<Item> items, Long maxPage, String message) {
        this.items = items;
        this.maxPage = maxPage;
        this.message = message;
    }

    public ItemsResponse() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Long maxPage) {
        this.maxPage = maxPage;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
