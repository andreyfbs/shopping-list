package br.com.santosandrey.sl.core.service;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListOutputDTO;

/**
 * This interface has the responsability of create a new Lists
 */
@FunctionalInterface
public interface CreateShoppingListService {

    /**
     * Create a new List
     * @return CreateShoppingListOutputDTO List Data after creation
     */
    CreateShoppingListOutputDTO createNewList(final CreateShoppingListInputDTO createShoppingListInputDTO);

}
