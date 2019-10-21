package repository;

import model.User;
import model.items.Item;
import model.items.payloads.REST.ItemFilter;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    // false if not found
    boolean delete(int id);

    // null if not found
    Optional<Item> get(int id);

    List<Item> getAll();

    public List<Item> getAllWithPagination(int first, int size);

    public Long countItems();

    public List<Item> getFilterWithPagination(int first, int size, ItemFilter filter);

    public Long countFilterItems( ItemFilter filter);

}
