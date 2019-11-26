package repository.item;

import model.items.ItemMesure;
import model.items.payloads.ItemMesureP;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemMesureRepositoryImp implements ItemMesureRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<ItemMesure> get(int id) {
        return Optional.ofNullable(em.find(ItemMesure.class,id));
    }

    @Override
    public Optional<ItemMesureP> getP(int id) {
        return Optional.ofNullable(em.find(ItemMesureP.class,id));
    }

    @Override
    public List<ItemMesureP> getAllP() {
        return em.createNamedQuery(ItemMesureP.GET_ALL).getResultList();
    }
}
