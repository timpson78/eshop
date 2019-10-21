package repository;

import model.User;
import model.items.Item;
import model.items.payloads.REST.ItemFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
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

    @Override
    public List<Item> getFilterWithPagination(int first, int size, ItemFilter filter) {
        String preperadfilterString = prepareFiltredQuery(filter);
        String query = "";
        if (preperadfilterString != "") {
            query = Item.NAMED_FILTER_QUERY + " WHERE" + preperadfilterString +" ORDER BY i.title";
            return  em.createQuery(query, Item.class).
                        setFirstResult(first).
                        setMaxResults(size).
                        getResultList();
        }

        return null;

    }

    @Override
    public Long countFilterItems(ItemFilter filter) {
        String preperadfilter = prepareFiltredQuery(filter);
        String query = Item.NAMED_FILTER_COUNT_QUERY+"WHERE"+prepareFiltredQuery (filter);
        if (preperadfilter != "") {
            return em.createQuery(query, Long.class).
                    getSingleResult();
        }
        return new Long(-1);
    }

    private String prepareFiltredQuery (ItemFilter filter ) {
           String query="";
           String andA = "";

        if (filter.getPartnumber()!=null && filter.getPartnumber()!="") {
            query += andA+" i.partnumber LIKE \'%"+filter.getPartnumber().toString() +"%\'";
            andA=" and";
        }

        if  (filter.getTitle()!= null && filter.getTitle()!="") {
            query += andA+" i.title LIKE \'%" + filter.getTitle() + "%\'";
            andA=" and";
        }

        if  (filter.getBrandId()!= null) {
            query += andA+" i.brand.id=" + filter.getBrandId().toString();
            andA=" and";
        }

        if  (filter.getCategoryId()!= null) {
            query += andA+" i.category.id=" + filter.getCategoryId().toString();
            andA=" and";
        }


        if  (filter.getPriceIn()!= null && filter.getPriceIn().floatValue()!= new BigDecimal(0).floatValue()) {
            query += andA+" i.price>" + filter.getPriceIn().floatValue();
            andA=" and";
        }

        if  (filter.getPriceOut()!= null && filter.getPriceOut().floatValue()!= new BigDecimal(0).floatValue()) {
            query += andA+" i.price<" + filter.getPriceOut().floatValue();
            andA=" and";
        }

        if (filter.getActivity()!=null && filter.getActivity()!=false) {
            query += andA+" i.activity=true";
            andA=" and";
        }

        if (filter.getSaleshit()!=null && filter.getSaleshit()!=false) {
            query += andA+" i.salesHit=true";
            andA=" and";
        }

        if (filter.getNewItem()!=null && filter.getNewItem()!=false) {
            query += andA+" i.newItem=true";
            andA=" and";
        }

        if (filter.getPromotion()!=null && filter.getPromotion()!=false) {
            query += andA+" i.promotion=true";
            andA=" and";
        }


        return query;
    }

}

