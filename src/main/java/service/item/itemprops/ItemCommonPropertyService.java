package service.item.itemprops;

import model.items.itemprops.ItemCommonProperty;
import model.items.itemprops.ItemPropertyGroup;
import model.items.itemprops.ItemPropertyValueType;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface ItemCommonPropertyService {

    ItemPropertyGroup createPropertyGroup(ItemPropertyGroup itemPropertyGroup);

    void deletePropertyGroup(int id) throws NotFoundException;

    void deleteListPropertyGroup(List<Integer> ids) throws NotFoundException;

    ItemPropertyGroup getPropertyGroup(int id) throws NotFoundException;

    void updatePropertyGroup(ItemPropertyGroup itemPropertyGroup);

    List<ItemPropertyGroup> getAllPropertyGroups();

    void deleteCommonProperty(int id) throws NotFoundException;

    ItemCommonProperty getCommonProperty(int id) throws NotFoundException;

    List<ItemCommonProperty> getAllCommonPropertyByGroupId(int groupId);

    ItemCommonProperty createCommonProperty(ItemCommonProperty itemCommonProperty);

    ItemCommonProperty updateCommonProperty(ItemCommonProperty itemCommonProperty);

    List<ItemPropertyValueType> getAllPropertyValueTypes();
}
