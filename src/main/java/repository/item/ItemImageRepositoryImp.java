package repository.item;

import model.items.payloads.ItemImageP;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ItemImageRepositoryImp implements ItemImageRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean deleteP(int id, int itemId) {
        return em.createNamedQuery(ItemImageP.DELETE)
                .setParameter("id",id)
                .setParameter("itemId",itemId)
                .executeUpdate()!=0;
    }

    @Override
    public ItemImageP save(ItemImageP itemImageP) {
        if (itemImageP.getId()==null) {
            em.persist(itemImageP);
            em.flush();
            return itemImageP;
        } else {
            return em.merge(itemImageP);
        }
    }
}
