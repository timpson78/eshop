package web.REST;

import model.items.*;
import model.items.payloads.REST.*;
import model.restpayloads.ItemsResponse;
import model.seo.SeoMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ItemBrandService;
import service.ItemCategoryService;
import service.ItemMesureService;
import service.ItemService;

import java.util.List;

@RestController
@RequestMapping(ItemController.REST_URL)
public class ItemController {

    static final String REST_URL = "/rest/items";

    @Autowired
    private ItemService service;

    @Autowired
    private ItemCategoryService serviceCategory;

    @Autowired
    private ItemBrandService serviceBrand;

    @Autowired
    private ItemMesureService serviceMesure;



    @Value("${app.pageSize}")
    private Integer pageSize;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getById(@PathVariable("id") int id) {
        Item item = service.get(id);
        int categoryId = -1;
        int mesureId = -1;
        int brandId = -1;

        if (item.getCategory() != null) categoryId = item.getCategory().getId();
        if (item.getMesure() != null) mesureId = item.getMesure().getId();
        if (item.getBrand() != null) brandId = item.getBrand().getId();

        return new ItemResponse(item, categoryId, mesureId, brandId);
    }

    @GetMapping(value = "/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemsResponse getAllbyPage(@PathVariable("page") int page) {
        List<Item> items = service.getAllByPage(page);
        Long maxPages = service.countPages();
        return new ItemsResponse(items, maxPages, "Ok");
    }

    @GetMapping(value = "/createEmptyItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer createEmptyItem() {
        Item newNullItem = new Item(null, "newEmptyItem", null, null, null, null, null, null, null, null, null, null, null,
                false, false, false, false, null, null);
        Item item = service.create(newNullItem);
        return item.getId();
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> deleteItem(@RequestBody Integer itemId) {
        service.delete(itemId);
        return new ResponseEntity("Item successfuly deleted", HttpStatus.OK);
    }


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SaveResponse> addItem(@RequestBody ItemShortP itemShortP) {
        Item newItem = new Item(null, itemShortP.getTitle(), null, null, null, itemShortP.getPrice(),
                itemShortP.getQuantity(), null, null, itemShortP.getPartnumber(), null,
                null, null, false, false, false, false, null, null);
        SeoMetaData  newSeoMetaData= new SeoMetaData(null,newItem,"","","");
        newItem.setSeoMetaData(newSeoMetaData);

        try {
            Item savedItem = service.create(newItem);
            return new ResponseEntity(new SaveResponse(savedItem.getId(), "Item successfuly added"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. The item is not saved", HttpStatus.NOT_FOUND);
        }


    }
    @PostMapping(value = "/item/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> updateItem(@RequestBody Item item) {
        ItemCategory itemCategory = null;
        ItemBrand itemBrand = null;
        ItemMesure itemMesure = null;
        try {
            if (item != null) {
                if (item.getCategory() != null) {
                    if (item.getCategory().getId()!=null)
                        if (item.getCategory().getId()>0) {
                            itemCategory = serviceCategory.get(item.getCategory().getId());
                        } else {
                            return new ResponseEntity("Category could not be empty. Please, fill the category", HttpStatus.NOT_FOUND);
                        }
                }

                if (item.getBrand()!=null) {
                    if (item.getBrand().getId()!=null)
                         if (item.getBrand().getId()>0) {
                             itemBrand = serviceBrand.get(item.getBrand().getId());
                         } else {
                             return new ResponseEntity(" Manufacturer could not be empty. Please, fill it", HttpStatus.NOT_FOUND);
                         }
                }
            }

            if (item.getMesure()!=null) {
                    if (item.getMesure().getId()!=null) {
                        if (item.getMesure().getId()>0) {
                            itemMesure = serviceMesure.get(item.getMesure().getId());
                        }else {
                            return new ResponseEntity(" Mesure could not be empty. Please, fill it", HttpStatus.NOT_FOUND);
                        }
                    }

            }
            if (item.getImages()!=null) {
                for (ItemImage image: item.getImages()) {
                    image.setItem(item);
                }
            }

            item.setCategory(itemCategory);
            item.setBrand(itemBrand);
            item.setMesure(itemMesure);

            item.getSeoMetaData().setItem(item);
            service.update(item);
            return new ResponseEntity("Item successfuly updated", HttpStatus.OK);
        } catch (Exception e)
        {

            return new ResponseEntity("Error. The item is not saved", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/item/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> deleteItem(@RequestBody int id) {
        try {
            service.delete(id);
            return new ResponseEntity("The item is successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. The item is not deleted", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getPages", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long getPages() {
        return  service.countPages();
    }

    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilterItemsResponse filter(@RequestBody FilterItemsRequest filterRequest) {
        Long maxFilterPages;
        List<Item> filterResult = service.getFilterWithPagination(filterRequest.getPage(), filterRequest.getFilter());
        if (filterResult==null){
            filterResult = service.getAllByPage(1);
            maxFilterPages = service.countPages();
        } else {
            maxFilterPages = service.countFilterItems(filterRequest.getFilter());
        }
        return  new FilterItemsResponse( maxFilterPages, filterResult);
    }


}
