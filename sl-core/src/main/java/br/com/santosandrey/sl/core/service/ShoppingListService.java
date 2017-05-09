package br.com.santosandrey.sl.core.service;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListOutputDTO;

public interface ShoppingListService {

    CreateShoppingListOutputDTO createNewList(CreateShoppingListInputDTO createShoppingListItemRequest);

}
