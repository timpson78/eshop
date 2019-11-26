package service.item;

import model.items.ItemCategory;
import model.items.payloads.ItemCategoryP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.item.ItemCategoryRepository;
import utils.exceptions.NotFoundException;

import java.util.List;

import static utils.ValidationUtil.checkNotFoundWithId;

@Service
public class ItemCategoryServiceImp  implements  ItemCategoryService{

    @Autowired
    ItemCategoryRepository repository;


    @Override
    public ItemCategory create(ItemCategory itemCategory) {
        Assert.notNull(itemCategory, "Category must not be null");
        return repository.save(itemCategory);
    }


    @Override
    public ItemCategoryP create(ItemCategoryP itemCategoryP) {
        Assert.notNull(itemCategoryP, "Category must not be null");
        return repository.saveP(itemCategoryP);
    }


    public ItemCategoryP createRoot(String name) {
        Assert.notNull(name, "Category must not be null");
        ItemCategoryP itemCategoryP = new ItemCategoryP(name,1,2,0,null,null);
        return repository.saveP(itemCategoryP);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public void deleteP(int id) throws NotFoundException {
        checkNotFoundWithId(repository.deleteP(id), id);
    }

    @Override
    public void deleteNodeFromTree(int id) throws NotFoundException {
       ItemCategoryP itemCategoryP = this.getP(id);
       if (!itemCategoryP.isLeaf()) {
           repository.deleteAllChildsP(itemCategoryP);
        }
        repository.deleteP(itemCategoryP.getId());
        repository.updateAfterDeleteP(itemCategoryP);
    }

    @Override
    public void updateNameP(int id, String name) throws NotFoundException {
        checkNotFoundWithId(repository.updateNameP(id, name), id);
    }

    @Override
    public ItemCategory get(int id) throws NotFoundException {
        return repository.get(id)
                .orElseThrow(() ->
                        new NotFoundException("category with " + id + " not found")
                );
    }

    @Override
    public ItemCategoryP getP(int id) throws NotFoundException {
        return repository.getP(id)
                .orElseThrow(() ->
                        new NotFoundException("category with " + id + " not found")
                );
    }

    @Override
    public ItemCategoryP getRootP() throws NotFoundException {
        return repository.getRootP()
                .orElseThrow(() ->
                        new NotFoundException("root category  not found")
                );
    }

    @Override
    public void update(ItemCategory itemCategory) {

    }

    @Override
    public List<ItemCategory> getAll() {
            return repository.getAll();
    }

    @Override
    public List<ItemCategory> getAllChilds(Integer idParent) {
        return repository.getAllChilds(idParent);
    }

    @Override
    public List<ItemCategoryP> getAllChildsP(Integer idParent) {
        return repository.getAllChildsP(idParent);
    }



    @Override
    public ItemCategory addChildAsFirst(ItemCategory parent, String name) throws Exception {
        ItemCategory newItemCategory= new ItemCategory();
        newItemCategory.setName(name);
        newItemCategory.setLeftKey(parent.getLeftKey()+1);
        newItemCategory.setRightKey(parent.getLeftKey()+2);
        newItemCategory.setLevel(parent.getLevel()+1);
        newItemCategory.setParent(parent);
        repository.updateCollectionAsFirst(newItemCategory);
        repository.save(newItemCategory);
        return newItemCategory;
    }

    @Override
    public ItemCategoryP addChildAsFirstP(ItemCategoryP parent, String name) throws Exception {
        ItemCategoryP newItemCategoryP= new ItemCategoryP();
        newItemCategoryP.setName(name);
        newItemCategoryP.setLeftKey(parent.getLeftKey()+1);
        newItemCategoryP.setRightKey(parent.getLeftKey()+2);
        newItemCategoryP.setLevel(parent.getLevel()+1);
        newItemCategoryP.setParent(parent);
        repository.updateCollectionAsFirst(newItemCategoryP);
        return  repository.saveP(newItemCategoryP);
    }

    @Override
    public ItemCategory addChildAsLast(ItemCategory parent, String name) throws Exception {
        ItemCategory newItemCategory= new ItemCategory();
        newItemCategory.setName(name);
        newItemCategory.setLeftKey(parent.getRightKey());
        newItemCategory.setRightKey(parent.getRightKey()+1);
        newItemCategory.setLevel(parent.getLevel()+1);
        newItemCategory.setParent(parent);
        repository.updateCollectionAsLast(newItemCategory);
        return  repository.save(newItemCategory);
    }
}
