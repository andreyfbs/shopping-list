package br.com.santosandrey.sl.core.converter;

import org.springframework.stereotype.Component;

import java.util.Date;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ShoppingListEntity;

@Component
public class ShoppingListEntityConverter {

    public ShoppingListEntity converterFrom(CreateShoppingListInputDTO createShoppingListInputDTO) {

        // Current date for both
        final Date creationDate = new Date();
        final Date updateDate = new Date();

        final String listName = createShoppingListInputDTO.getCreateShoppingListDTO().getListName();
        final Long userOwnerId = createShoppingListInputDTO.getUserId();
        final Long lastIdLastChanged = createShoppingListInputDTO.getUserId();
        // First Version
        final Long listCurrentVersion = 1L;

        final ShoppingListEntity shoppingListEntity = new ShoppingListEntity(listName, userOwnerId, creationDate, updateDate, lastIdLastChanged, listCurrentVersion);

        return shoppingListEntity;
    }
}
