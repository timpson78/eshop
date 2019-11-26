package service.item;


import model.items.ItemBrand;
import model.items.payloads.ItemBrandP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.item.ItemBrandRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

@Service
public class ItemBrandServiceImp implements ItemBrandService {

    @Autowired
    ItemBrandRepository repository;


    @Override
    public ItemBrandP findByIdP(int id) {
        return null;
    }

    @Override
    public ItemBrandP create(ItemBrand itemBrand) {
        return null;
    }

    @Override
    public void deleteP(int id) throws NotFoundException {

    }

    @Override
    public ItemBrandP getP(int id) throws NotFoundException {
        return null;
    }

    @Override
    public ItemBrand get(int id) throws NotFoundException {

        return repository.get(id)
                .orElseThrow(() ->
                        new NotFoundException("Item brand with " + id + " not found")
                );
    }

    @Override
    public void updateP(ItemBrandP itemBrand) {

    }

    @Override
    public List<ItemBrandP> getAll() {
        return repository.getAllP();
    }
}
