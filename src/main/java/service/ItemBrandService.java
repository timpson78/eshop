package service;

import model.items.ItemBrand;
import model.items.payloads.ItemBrandP;
import utils.exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;

public interface ItemBrandService {

    ItemBrandP findByIdP(int id);

    ItemBrandP create(ItemBrand itemBrand);

    void deleteP(int id) throws NotFoundException;

    ItemBrandP getP(int id) throws NotFoundException;

   ItemBrand get(int id) throws NotFoundException;

    void updateP(ItemBrandP itemBrand);

    List<ItemBrandP> getAll();
}
