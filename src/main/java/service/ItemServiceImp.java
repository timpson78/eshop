package service;

import model.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.ItemRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository repository;

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public Item create(Item item) {
        Assert.notNull(item, "user must not be null");
        return repository.save(item);
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Item get(int id) throws NotFoundException {
            return repository.get(id);
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public List<Item> getAll() {
        return null;
    }
}
