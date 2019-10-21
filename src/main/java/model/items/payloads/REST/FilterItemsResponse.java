package model.items.payloads.REST;

import model.items.Item;

import java.util.List;

public class FilterItemsResponse {

    private Long maxPage;

    private List<Item> items;


    public FilterItemsResponse() {

    }

    public FilterItemsResponse(Long maxPage, List<Item> items) {
        this.maxPage = maxPage;
        this.items = items;
    }


    public Long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Long maxPage) {
        this.maxPage = maxPage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
