package service;

import io.jsonwebtoken.lang.Assert;
import model.items.payloads.ItemImageP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemImageRepository;
import utils.exceptions.NotFoundException;

import static utils.ValidationUtil.checkNotFoundWithId;

@Service
public class ItemImageServiceImp implements ItemImageService{

    @Autowired
    ItemImageRepository repository;


    @Override
    public void deleteP(int id, int itemId) throws NotFoundException {
        checkNotFoundWithId(repository.deleteP(id,itemId), id,itemId);
    }

    @Override
    public void updateP(ItemImageP itemImageP) throws NotFoundException {
        Assert.notNull(itemImageP, "itemImageP  must not be null");
        repository.save(itemImageP);
    }

    @Override
    public ItemImageP create(ItemImageP itemImageP) {
        Assert.notNull(itemImageP, "itemImageP  must not be null");
       return repository.save(itemImageP);
    }
}
