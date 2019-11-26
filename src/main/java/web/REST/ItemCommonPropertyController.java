package web.REST;


import model.items.itemprops.ItemCommonProperty;
import model.items.itemprops.ItemPropertyGroup;
import model.items.itemprops.ItemPropertyValueType;
import model.items.payloads.REST.SaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.item.itemprops.ItemCommonPropertyService;
import java.util.List;

@RestController
@RequestMapping(ItemCommonPropertyController.REST_URL)
public class ItemCommonPropertyController {

    static final String REST_URL = "/rest/itemcommonproperties";

    @Autowired
    private ItemCommonPropertyService service;


    @GetMapping(value = "/propertygroup/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemPropertyGroup> getAll() {
        return service.getAllPropertyGroups();
    }


    @PostMapping(value = "/propertygroup/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaveResponse> createPropertyGroup(@RequestBody ItemPropertyGroup propertyGroup) {
        try {
            ItemPropertyGroup savedPropertyGroup = service.createPropertyGroup(propertyGroup);
            return new ResponseEntity(new SaveResponse(savedPropertyGroup.getId(), "Property group is  successfuly created"), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity("Error. Property group  is not created", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/propertygroup/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePropertyGroup(@RequestBody ItemPropertyGroup propertyGroup) {
        try {
            service.updatePropertyGroup(propertyGroup);
            return new ResponseEntity("Property group is successfuly updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. Property group  is not updated", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/propertygroup/deletelist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteListPropertyGroup(@RequestBody List<Integer> ids) {
        try {
            service.deleteListPropertyGroup(ids);
            return new ResponseEntity("Property groups are successfuly  deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. Property groups  are not deleted", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/proprtygroup/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemPropertyGroup getPropertyGroup(@PathVariable("id") int id) {
            return service.getPropertyGroup(id);
    }


    @GetMapping(value = "/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemCommonProperty> getAllCommonPropertiesByGrpoupId(@PathVariable("groupId") int groupId) {
        return service.getAllCommonPropertyByGroupId(groupId);
    }

    @GetMapping(value = "/valuetype/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemPropertyValueType> getAlPropertyValueTypies() {
        return service.getAllPropertyValueTypes();
    }


    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCommonProperty(@RequestBody ItemCommonProperty commonProperty) {
        try {
            service.updateCommonProperty(commonProperty);
            return new ResponseEntity("Common property  is successfuly updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. Common property   is not updated", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaveResponse> createCommonProperty(@RequestBody ItemCommonProperty commonProperty) {
        try {
            ItemCommonProperty savedCommonProperty = service.createCommonProperty(commonProperty);
            return new ResponseEntity(new SaveResponse(savedCommonProperty.getId(),"Common property  is successfuly updated"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. Common property   is not created", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCommonProperty(@RequestBody Integer id) {
        try {
            service.deleteCommonProperty(id);
            return new ResponseEntity("Common property are successfuly  deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error. Common property   are not deleted", HttpStatus.NOT_FOUND);
     }
    }

}
