package br.com.santosandrey.sl.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.santosandrey.sl.core.ShoppingListService;

@RestController
public class CreateShoppingListResource {

    @Autowired
    private ShoppingListService shoppingListService;

    @RequestMapping(method = RequestMethod.POST, value = EndPointURL.URL_SHOPPING_LIST)
    public ResponseEntity<String> createNewList() {
        shoppingListService.createNewList();
        return ResponseEntity.status(HttpStatus.CREATED).body("List created");
    }
}