package web.REST;


import model.items.payloads.ItemBrandP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.item.ItemBrandService;

import java.util.List;

@RestController
@RequestMapping(ItemBrandController.REST_URL)
public class ItemBrandController {

    static final String REST_URL = "/rest/brand";

    @Autowired
    private ItemBrandService service;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemBrandP> getAll() {
        return service.getAll();
    }
}
