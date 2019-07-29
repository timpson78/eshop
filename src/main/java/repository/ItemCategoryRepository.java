package repository;


import model.items.ItemCategory;
import model.items.payloads.ItemCategoryP;

import java.util.List;
import java.util.Optional;

public interface ItemCategoryRepository {

    ItemCategory save(ItemCategory itemCategory);

    ItemCategoryP saveP(ItemCategoryP itemCategoryP);

    // false if not found
    boolean delete(int id);

    boolean deleteP(int id);

    boolean deleteAllChildsP(ItemCategoryP itemCategoryP);

   // boolean delete(ItemCategory itemCategory);

    boolean updateAfterDeleteP(ItemCategoryP itemCategoryP);

    boolean deleteP(ItemCategoryP itemCategoryP);


    // null if not found
    Optional<ItemCategory> get(int id);

    Optional<ItemCategoryP> getP(int id);

    Optional<ItemCategoryP>  getRootP();

    List< ItemCategory> getAll();

    List< ItemCategory> getAllChilds(Integer idParent);

    List<ItemCategoryP> getAllChildsP(Integer idParent);

    public boolean updateNameP(int id, String name);

    public void updateCollectionAsFirst(ItemCategory itemCategory);

    public void updateCollectionAsFirst(ItemCategoryP itemCategoryP);

    public void updateCollectionAsLast(ItemCategory itemCategory);
}
