package repository;

import model.User;
import model.items.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ItemRepositoryImp implements ItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Item save(Item item) {
        if (item.getId()==null) {
            em.persist(item);
            em.flush();
            return item;
        } else {
            return em.merge(item);
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Item get(int id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> getAll() {
        return null;
    }


}

