package service;

import model.items.ItemCategory;
import model.items.payloads.ItemCategoryP;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface ItemCategoryService {


    ItemCategory create(ItemCategory itemCategory);

    ItemCategoryP create(ItemCategoryP itemCategoryP);

    void delete(int id) throws NotFoundException;

    void deleteP(int id) throws NotFoundException;

    void deleteNodeFromTree(int id) throws NotFoundException;

    void updateNameP(int id, String name) throws NotFoundException;



    ItemCategory get(int id) throws NotFoundException;

    ItemCategoryP getP(int id) throws NotFoundException;

    ItemCategoryP getRootP() throws NotFoundException;

    void update(ItemCategory itemCategory);

    List<ItemCategory> getAll();



    List<ItemCategory> getAllChilds(Integer idParent);

    List<ItemCategoryP> getAllChildsP(Integer idParent);

    public ItemCategory addChildAsFirst(ItemCategory parent, String name) throws Exception;

    public ItemCategoryP addChildAsFirstP(ItemCategoryP parent, String name) throws Exception;



    public ItemCategory addChildAsLast(ItemCategory parent, String name) throws Exception;
}
