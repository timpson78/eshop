package service;

import model.items.payloads.ItemImageP;
import utils.exceptions.NotFoundException;

public interface ItemImageService {

    void deleteP(int id, int itemId) throws NotFoundException;

    void updateP(ItemImageP itemImageP)throws NotFoundException;

    ItemImageP create(ItemImageP itemImageP);

}
