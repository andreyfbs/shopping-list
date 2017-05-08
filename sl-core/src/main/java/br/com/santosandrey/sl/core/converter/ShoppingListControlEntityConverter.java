package br.com.santosandrey.sl.core.converter;

import org.springframework.stereotype.Component;

import java.util.Date;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ShoppingListControlEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;

@Component
public class ShoppingListControlEntityConverter {

    public ShoppingListControlEntity converterFrom(CreateShoppingListInputDTO createShoppingListInputDTO, ShoppingListEntity shoppingListEntity) {

        // Current date for both
        final Date creationDate = new Date();
        final Date updateDate = new Date();

        final Long userId = createShoppingListInputDTO.getUserId();
        final Long accountDeviceId = createShoppingListInputDTO.getAccountDeviceId();
        final Long listId = shoppingListEntity.getId();
        final Long listVersion = shoppingListEntity.getCurrentVersion();

        return new ShoppingListControlEntity(userId, accountDeviceId, listId, creationDate, updateDate, listVersion);
    }

}
