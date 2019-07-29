package repository;


import model.items.ItemCategory;
import model.items.payloads.ItemCategoryP;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)

public class ItemCategoryRepositoryImp implements  ItemCategoryRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public ItemCategory save(ItemCategory itemCategory) {
        if (itemCategory.getId()==null) {
            em.persist(itemCategory);
            em.flush();
            return itemCategory;
        } else {
            return em.merge(itemCategory);
        }
    }

    @Override
    public ItemCategoryP saveP(ItemCategoryP itemCategoryP) {
        if (itemCategoryP.getId()==null) {
            em.persist(itemCategoryP);
            em.flush();
            return itemCategoryP;
        } else {
            return em.merge(itemCategoryP);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(ItemCategory.DELETE_BYID)
                .setParameter("id", id)
                .executeUpdate() != 0;

    }

    @Override
    public boolean deleteP(int id) {
        return em.createNamedQuery(ItemCategoryP.DELETE_BYID)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public boolean deleteAllChildsP(ItemCategoryP itemCategoryP) {
        return em.createNamedQuery(ItemCategoryP.DELETE_ALL_CHILDS)
                .setParameter("lft", itemCategoryP.getLeftKey())
                .setParameter("rgt", itemCategoryP.getRightKey())
                .executeUpdate() != 0;
    }

    @Override
    public boolean updateAfterDeleteP(ItemCategoryP itemCategoryP) {

        int left = itemCategoryP.getLeftKey();
        int right = itemCategoryP.getRightKey();
        int width = right - left + 1;

        em.createNamedQuery(ItemCategory.UPDATE_RGTKEY_ON_DELETE)
                .setParameter("width", width)
                .setParameter("right", right)
                .executeUpdate();

        em.createNamedQuery(ItemCategory.UPDATE_LFTKEY_ON_DELETE)
                .setParameter("width", width)
                .setParameter("right", right)
                .executeUpdate();

        return true;
    }

    @Override
    public boolean deleteP(ItemCategoryP itemCategoryP) {
        return false;
    }


    @Override
    public Optional<ItemCategoryP>  getRootP() {
        return Optional.ofNullable(em.createNamedQuery(ItemCategoryP.GET_ROOT, ItemCategoryP.class).getSingleResult());
    }

    @Override
    public Optional<ItemCategory> get(int id) {
        return Optional.ofNullable(em.find(ItemCategory.class, id));
    }

    @Override
    public Optional<ItemCategoryP> getP(int id) {
        return Optional.ofNullable(em.find(ItemCategoryP.class, id));
    }

    @Override
    public List<ItemCategory> getAll() {
        return em.createNamedQuery(ItemCategory.GET_ALL_SORTED, ItemCategory.class).getResultList();
    }

    @Override
    public List<ItemCategory> getAllChilds(Integer idParent) {
        return null;
    }

    @Override
    public List<ItemCategoryP> getAllChildsP(Integer idParent) {
        if (idParent!=null) {
            return em.createNamedQuery(ItemCategoryP.GET_ALL_CHILDS, ItemCategoryP.class).
                    setParameter("idParent",idParent).
                    getResultList();
        } else {
            return em.createNamedQuery(ItemCategoryP.GET_ALL_CHILDS_NULL, ItemCategoryP.class).getResultList();
        }
    }

    @Override
    public boolean updateNameP(int id, String name) {
        return em.createNamedQuery(ItemCategoryP.UPDATE_NAME)
                .setParameter("id", id)
                .setParameter("name", name)
                .executeUpdate()!=0;
    }

    public void updateCollectionAsFirst(ItemCategory itemCategory) {

        em.createNamedQuery(ItemCategory.UPDATE_FIRSTRIGHTKEY)
                .setParameter("newRight", itemCategory.getRightKey() -1)
                .executeUpdate();

        em.createNamedQuery(ItemCategory.UPDATE_FIRSTLEFTKEY)
                .setParameter("newRight", itemCategory.getRightKey() -1)
                .executeUpdate();
    }

    @Override
    public void updateCollectionAsFirst(ItemCategoryP itemCategoryP) {

        em.createNamedQuery(ItemCategory.UPDATE_FIRSTRIGHTKEY)
                .setParameter("newRight", itemCategoryP.getRightKey() -1)
                .executeUpdate();

        em.createNamedQuery(ItemCategory.UPDATE_FIRSTLEFTKEY)
                .setParameter("newRight", itemCategoryP.getRightKey() -1)
                .executeUpdate();

    }

    public void updateCollectionAsLast(ItemCategory itemCategory) {

        em.createNamedQuery(ItemCategory.UPDATE_LASTRIGHTKEY)
                .setParameter("newLeft", itemCategory.getLeftKey() -1)
                .executeUpdate();

        em.createNamedQuery(ItemCategory.UPDATE_LASTLEFTKEY)
                .setParameter("newLeft", itemCategory.getLeftKey() -1)
                .executeUpdate();
    }


}
