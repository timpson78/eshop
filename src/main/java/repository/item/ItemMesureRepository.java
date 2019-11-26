package repository.item;

import model.items.ItemMesure;
import model.items.payloads.ItemMesureP;

import java.util.List;
import java.util.Optional;

public interface ItemMesureRepository {


    Optional<ItemMesure> get(int id);

    Optional<ItemMesureP> getP(int id);

    List<ItemMesureP> getAllP ();

}
