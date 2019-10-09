package service;

import model.items.ItemMesure;
import model.items.payloads.ItemMesureP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemMesureRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

@Service
public class ItemMesureServiceImp implements ItemMesureService {

    @Autowired
    ItemMesureRepository repository;

    @Override
    public ItemMesure get(int id) {
        return repository.get(id)
                .orElseThrow(() ->
                        new NotFoundException("Mesure brand with " + id + " not found")
                );
    }

    @Override
    public ItemMesureP getP(int id) {

         return repository.getP(id)
                .orElseThrow(() ->
                        new NotFoundException("Mesure brand with " + id + " not found")
                );
    }

    @Override
    public List<ItemMesureP> getAllP() {
        return   repository.getAllP();
    }


}
