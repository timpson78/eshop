package repository;

import model.User;
import model.items.Item;

import java.util.List;

public interface ItemRepository {

    Item save(Item item);

    // false if not found
    boolean delete(int id);

    // null if not found
    Item get(int id);

    List<Item> getAll();

}
