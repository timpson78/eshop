package web.REST;

import model.items.payloads.ItemMesureP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ItemMesureService;

import java.util.List;

@RestController
@RequestMapping( ItemMesureController.REST_URL)
public class ItemMesureController {

    static final String REST_URL="/rest/mesure";

    @Autowired
    ItemMesureService service;

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemMesureP> getAll () {
        return service.getAllP();
    }
}
