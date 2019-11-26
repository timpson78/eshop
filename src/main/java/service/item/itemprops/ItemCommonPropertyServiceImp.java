package service.item.itemprops;

import model.items.itemprops.ItemCommonProperty;
import model.items.itemprops.ItemPropertyGroup;
import model.items.itemprops.ItemPropertyValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.item.ItemRepository;
import repository.item.itemprops.ItemCommonPropertyRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

import static utils.ValidationUtil.checkNotFoundWithId;

@Service
public class ItemCommonPropertyServiceImp implements ItemCommonPropertyService {

    @Autowired
    ItemCommonPropertyRepository repository;

    @Override
    public ItemPropertyGroup createPropertyGroup(ItemPropertyGroup itemPropertyGroup) {
        Assert.notNull(itemPropertyGroup, "property group must not be null");
        return repository.savePropertyGroup(itemPropertyGroup);
    }

    @Override
    public void deletePropertyGroup(int id) throws NotFoundException {

    }

    @Override
    public void deleteListPropertyGroup(List<Integer> ids) throws NotFoundException {
        repository.deleteListPropertyGroup(ids);
    }


    @Override
    public ItemPropertyGroup getPropertyGroup(int id) throws NotFoundException {
        return repository.getPropertyGroup(id)
                .orElseThrow(() ->
                        new NotFoundException("Property group with " + id + " not found")
                );
    }

    @Override
    public void updatePropertyGroup(ItemPropertyGroup itemPropertyGroup) {
        Assert.notNull(itemPropertyGroup, "Property group must not be null");
        repository.savePropertyGroup(itemPropertyGroup);
    }



    @Override
    public List<ItemPropertyGroup> getAllPropertyGroups() {
        return repository.getAllPropertyGroups();
    }

    @Override
    public void deleteCommonProperty(int id) throws NotFoundException {
        checkNotFoundWithId(repository.deleteCommonProperty(id),id);
    }

    @Override
    public ItemCommonProperty getCommonProperty(int id) throws NotFoundException {
        return repository.getCommonProperty(id)
                .orElseThrow(() ->
                        new NotFoundException("CommonProperty with " + id + " not found")
                );
    }

    @Override
    public List<ItemCommonProperty> getAllCommonPropertyByGroupId(int groupId) {
        return repository.getAllItemCommonPropertyByGroupId(groupId);
    }

    @Override
    public ItemCommonProperty createCommonProperty(ItemCommonProperty itemCommonProperty) {
        Assert.notNull(itemCommonProperty, "Item common property must not be null");
        return repository.saveCommonProperty(itemCommonProperty);
    }

    @Override
    public ItemCommonProperty updateCommonProperty(ItemCommonProperty itemCommonProperty) {
        Assert.notNull(itemCommonProperty, "Item common property must not be null");
        return repository.saveCommonProperty(itemCommonProperty);
    }


    @Override
    public List<ItemPropertyValueType> getAllPropertyValueTypes() {
        return repository.getAllPropertyValueTypes();
    }
}
