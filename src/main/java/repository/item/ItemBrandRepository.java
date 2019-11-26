package repository.item;

import model.items.ItemBrand;
import model.items.payloads.ItemBrandP;

import java.util.List;
import java.util.Optional;

public  interface ItemBrandRepository {

    // false if not found
    boolean delete(int id);

    // null if not found
    ItemBrandP getP(int id);

    Optional<ItemBrand> get(int id);

    List<ItemBrandP> getAllP();

    public boolean updateP(int id);

}
