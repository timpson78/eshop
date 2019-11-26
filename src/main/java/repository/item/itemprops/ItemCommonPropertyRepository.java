package repository.item.itemprops;

import model.items.Item;
import model.items.itemprops.ItemCommonProperty;
import model.items.itemprops.ItemPropertyGroup;
import model.items.itemprops.ItemPropertyValueType;

import java.util.List;
import java.util.Optional;

public interface ItemCommonPropertyRepository {

    ItemPropertyGroup savePropertyGroup(ItemPropertyGroup itemPropertyGroup);

    // false if not found
    boolean deletePropertyGroup(int id);

    boolean deleteListPropertyGroup( List<Integer> ids);

    // null if not found
    Optional<ItemPropertyGroup> getPropertyGroup(int id);

    List<ItemPropertyGroup> getAllPropertyGroups();


    ItemCommonProperty saveCommonProperty(ItemCommonProperty itemCommonProperty);

    boolean deleteCommonProperty(int id);

    Optional<ItemCommonProperty> getCommonProperty(int id);

    List<ItemCommonProperty> getAllItemCommonPropertyByGroupId(int groupId);


    List<ItemPropertyValueType> getAllPropertyValueTypes();
}
