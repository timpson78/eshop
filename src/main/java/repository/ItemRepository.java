package repository;

import model.User;
import model.items.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    // false if not found
    boolean delete(int id);

    // null if not found
    Optional<Item> get(int id);

    List<Item> getAll();

    public List<Item> getAllWithPagination(int first, int last);

    public Long countItems();

}
