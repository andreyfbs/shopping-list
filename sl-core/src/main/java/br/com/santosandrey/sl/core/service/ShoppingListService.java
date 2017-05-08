package br.com.santosandrey.sl.core.service;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;

public interface ShoppingListService {

    void createNewList(CreateShoppingListInputDTO createShoppingListItemRequest);

}
