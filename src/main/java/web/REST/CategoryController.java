package web.REST;


import model.items.ItemCategory;
import model.items.payloads.ItemCategoryP;
import model.items.payloads.REST.CategoryR;
import model.items.payloads.REST.SaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ItemCategoryService;

import java.util.List;

@RestController
@RequestMapping(CategoryController.REST_URL)
public class CategoryController {

    static final String REST_URL = "/rest/category";

    @Autowired
    private ItemCategoryService service;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemCategory> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/byparent/{idParent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemCategoryP> getAllChilds(@PathVariable("idParent") Integer idParent) {
        List<ItemCategoryP> items = service.getAllChildsP(idParent);
        return items;
    }
    @GetMapping(value = "/byparent/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemCategoryP> getAllRootChilds() {
        List<ItemCategoryP> items = service.getAllChildsP(null);
        return items;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemCategory get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SaveResponse> create(@RequestBody CategoryR categoryR) {
        ItemCategoryP parentCategoryP;
        try {
            if (categoryR.getParentId()!=0) {
                parentCategoryP = service.getP(categoryR.getParentId());
            } else {
                parentCategoryP = service.getRootP();
            }
            ItemCategoryP savedItemCategoryP = service.addChildAsFirstP(parentCategoryP, categoryR.getName());
            return new ResponseEntity(new SaveResponse(savedItemCategoryP.getId(),
                    "Category successfuly saved"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.toString(),
                    HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping(value = "/updatename", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SaveResponse> updateNameP(@RequestBody CategoryR categoryR) {
        service.updateNameP(categoryR.getId(),categoryR.getName());
        return new ResponseEntity("Category successfuly updated", HttpStatus.OK);
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SaveResponse> deleteP(@RequestBody CategoryR categoryR) {
        service.deleteNodeFromTree(categoryR.getId());
        return new ResponseEntity("Category successfuly deleted", HttpStatus.OK);
    }


}
