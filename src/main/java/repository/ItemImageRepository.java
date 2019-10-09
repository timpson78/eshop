package repository;

import model.items.payloads.ItemImageP;

public interface ItemImageRepository {

    public boolean deleteP(int id, int itemId);

    ItemImageP save(ItemImageP itemImageP);
}
