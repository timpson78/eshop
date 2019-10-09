package service;

import model.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.ItemRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

import static utils.ValidationUtil.checkNotFoundWithId;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository repository;

    @Value("${app.pageSize}")
    private  int pageSize;


    @Override
    public Item create(Item item) {
        Assert.notNull(item, "item must not be null");
        return repository.save(item);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public Item get(int id) throws NotFoundException {
        return repository.get(id)
                .orElseThrow(() ->
                        new NotFoundException("Item with " + id + " not found")
                );
    }

    @Override
    public void update(Item item) {
        Assert.notNull(item, "item  must not be null");
        repository.save(item);
    }

    @Override
    public List<Item> getAll() {

        return repository.getAll();
    }

    @Override
    public List<Item> getAllByPage(int page) {
        int size = this.pageSize;
        int first = 1;
        if (page>0) { first = page * size - size; }

        List<Item> items = repository.getAllWithPagination(first,size);
        return items;
    }

    public Long countPages() {
        Long maxItems = repository.countItems();
        return new Double(Math.ceil((double)maxItems/pageSize)).longValue();
    }


}
