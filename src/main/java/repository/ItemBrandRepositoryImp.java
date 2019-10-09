package repository;

import model.items.Item;
import model.items.ItemBrand;
import model.items.payloads.ItemBrandP;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)
public class ItemBrandRepositoryImp implements ItemBrandRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public ItemBrandP getP(int id) {
        return null;
    }

    @Override
    public Optional<ItemBrand> get(int id) {
        return Optional.ofNullable(em.find(ItemBrand.class, id));
    }


    @Override
    public List<ItemBrandP> getAllP() {
        return em.createNamedQuery(ItemBrandP.GET_ALL).getResultList();
    }

    @Override
    public boolean updateP(int id) {
        return false;
    }
}
