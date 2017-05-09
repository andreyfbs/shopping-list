package br.com.santosandrey.sl.core.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListItemDTO;
import br.com.santosandrey.sl.model.ItemEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;

@Component
public class ItemEntityConverter {

    public List<ItemEntity> converterFrom(CreateShoppingListInputDTO createShoppingListInputDTO, ShoppingListEntity shoppingListEntity) {

        // Current date for both
        final Date creationDate = new Date();
        final Date updateDate = new Date();

        List<ItemEntity> itemEntityList = new ArrayList<>();
        for (CreateShoppingListItemDTO createShoppingListItemDTO : createShoppingListInputDTO.getCreateShoppingListDTO().getItems()) {

            String itemName = createShoppingListItemDTO.getItemName();
            Boolean markedChecked = createShoppingListItemDTO.isChecked();
            String quantityDescription = createShoppingListItemDTO.getQuantityDescription();

            ItemEntity itemEntity = new ItemEntity(itemName, markedChecked, quantityDescription, creationDate, updateDate, shoppingListEntity, createShoppingListItemDTO.getItemIdDevice());
            itemEntityList.add(itemEntity);

        }
        return itemEntityList;
    }
}
