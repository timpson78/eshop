package service;

import model.User;
import model.items.Item;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface ItemService {

    Item findById(int id);

    Item create(Item item);

    void delete(int id) throws NotFoundException;

    Item get(int id) throws NotFoundException;

    void update(Item item);

    List<Item> getAll();


}
