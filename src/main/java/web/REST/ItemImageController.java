package web.REST;

import model.items.payloads.ItemImageP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.File.FileStorageService;
import service.ItemImageService;

@RestController
@RequestMapping( ItemImageController.REST_URL)
public class ItemImageController {
    public static final String REST_URL="/rest/itemimage/";

    @Autowired
    ItemImageService service;

    @Autowired
    FileStorageService fileService;

    @PostMapping(value = "/delete/id={id}&itemId={itemId}&fileName={fileName:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteItem(@PathVariable("id") int id, @PathVariable("itemId") int itemId, @PathVariable("fileName")String fileName )     {
            service.deleteP(id, itemId);
            if (fileName!=null)
                fileService.deleteFile(fileName);
    }

    @PostMapping(value = "/add/itemId={itemId}&fileName={fileName:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addItem( @PathVariable("itemId") int itemId, @PathVariable("fileName")String fileName )     {
        service.create(new ItemImageP(null,itemId,fileName));
    }

    @PostMapping(value = "/update/id={id}&itemId={itemId}&fileName={fileName:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@PathVariable("id") int id, @PathVariable("itemId") int itemId, @PathVariable("fileName")String fileName )     {
        service.updateP(new ItemImageP(id,itemId,fileName));
    }

}
