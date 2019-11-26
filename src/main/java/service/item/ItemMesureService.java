package service.item;

import model.items.ItemMesure;
import model.items.payloads.ItemMesureP;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface ItemMesureService {

    ItemMesure get(int id);

    ItemMesureP getP(int id);

    List<ItemMesureP> getAllP();
}
