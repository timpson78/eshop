package model.items.payloads.REST;

public class FilterItemsRequest {

    private int page;

    private ItemFilter filter;

    public FilterItemsRequest(int page, ItemFilter filter) {
        this.page = page;
        this.filter = filter;
    }

    public FilterItemsRequest(){

    }


    public int getPage() {
        return page;
    }


    public ItemFilter getFilter() {
        return filter;
    }

    public void setFilter(ItemFilter filter) {
        this.filter = filter;
    }
}
