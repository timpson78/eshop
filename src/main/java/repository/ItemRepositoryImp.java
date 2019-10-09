package repository;

import model.User;
import model.items.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)
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
        return em.createNamedQuery(Item.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Optional<Item> get(int id) {
        return  Optional.ofNullable(em.find(Item.class, id));
    }

    @Override
    public List<Item> getAll() {
         return em.createNamedQuery(Item.GET_ALL, Item.class)
                .getResultList();

//        List<Item> items = convertToItems(queryResult);
//        return items;
    }

    @Override
    public List<Item> getAllWithPagination(int first, int size) {
       return em.createNamedQuery(Item.GET_ALL, Item.class)
                .setFirstResult(first)
                .setMaxResults(size)
                .getResultList();

//        List<Item> items = convertToItems(queryResult);
//        return items;
    }

//    private List<Item> convertToItems(List<Object[]> queryResult) {
//        List<Item> items = new ArrayList<>();
//        for (Object[] row: queryResult)
//        {
//            items.add((Item)row[0]) ;
//        }
//        return items;
//    }

    @Override
    public Long countItems() {
       return em.createNamedQuery(Item.COUNT_ALL, Long.class)
                .getSingleResult();
    }

}

