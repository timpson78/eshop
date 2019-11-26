package repository.item.itemprops;

import model.items.itemprops.ItemCommonProperty;
import model.items.itemprops.ItemPropertyGroup;
import model.items.itemprops.ItemPropertyValueType;
import model.items.payloads.ItemMesureP;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)
public class ItemCommonPropertyRepositoryImp implements ItemCommonPropertyRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public ItemPropertyGroup savePropertyGroup(ItemPropertyGroup itemPropertyGroup) {
        if (itemPropertyGroup.getId()==null) {
            em.persist(itemPropertyGroup);
            em.flush();
            return itemPropertyGroup;
        } else {
            return em.merge(itemPropertyGroup);
        }
    }

    @Override
    public boolean deletePropertyGroup(int id) {

      return  em.createNamedQuery(ItemPropertyGroup.DELETE)
                .setParameter("id", id)
                .executeUpdate()!=0;

    }

    @Override
    public boolean deleteListPropertyGroup(List<Integer> ids) {
        em.flush();
        em.clear();
        em.createNamedQuery(ItemPropertyGroup.DELETE_LIST)
                .setParameter("ids", ids)
                .executeUpdate();

        return em.createNamedQuery(ItemCommonProperty.DELETE_ALL_GROUP)
                .setParameter("ids", ids)
                .executeUpdate() != 0;
    }

    @Override
    public Optional<ItemPropertyGroup> getPropertyGroup(int id) {
        return Optional.ofNullable(em.find(ItemPropertyGroup.class,id));
    }

    @Override
    public List<ItemPropertyGroup> getAllPropertyGroups() {
        return em.createNamedQuery(ItemPropertyGroup.GET_ALL, ItemPropertyGroup.class)
                .getResultList();
    }

    @Override
    public ItemCommonProperty saveCommonProperty(ItemCommonProperty itemCommonProperty) {
        if (itemCommonProperty.getId()==null) {
            em.persist(itemCommonProperty);
            em.flush();
            return itemCommonProperty;
        } else {
            return em.merge(itemCommonProperty);
        }
    }

    @Override
    public boolean deleteCommonProperty(int id) {
        return em.createNamedQuery(ItemCommonProperty.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Optional<ItemCommonProperty> getCommonProperty(int id) {
        return Optional.ofNullable(em.find(ItemCommonProperty.class,id));
    }

    @Override
    public List<ItemCommonProperty> getAllItemCommonPropertyByGroupId(int groupId) {
        return em.createNamedQuery(ItemCommonProperty.GET_ALL, ItemCommonProperty.class)
                .setParameter("groupId", groupId)
                .getResultList();
    }

    @Override
    public List<ItemPropertyValueType> getAllPropertyValueTypes() {
        return em.createNamedQuery(ItemPropertyValueType.GET_ALL, ItemPropertyValueType.class)
                .getResultList();
    }


}
