package service;

import model.User;
import model.items.Item;
import model.items.payloads.REST.ItemFilter;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface ItemService {

    Item create(Item item);

    void delete(int id) throws NotFoundException;

    Item get(int id) throws NotFoundException;

    void update(Item item);

    List<Item> getAll();

    List<Item> getAllByPage(int page);

    public Long countPages();

    public List<Item> getFilterWithPagination(int page, ItemFilter filter);

    public Long countFilterItems(ItemFilter filter);

}
