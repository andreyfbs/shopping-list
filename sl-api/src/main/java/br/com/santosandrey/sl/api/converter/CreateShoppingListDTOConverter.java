package br.com.santosandrey.sl.api.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import br.com.santosandrey.sl.api.dto.CreateShoppingListItemRequest;
import br.com.santosandrey.sl.api.dto.CreateShoppingListRequest;
import br.com.santosandrey.sl.core.dto.CreateShoppingListDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListItemDTO;

@Component
public class CreateShoppingListDTOConverter {

    public CreateShoppingListDTO convertFrom(CreateShoppingListRequest createShoppingListRequest) {

        List<CreateShoppingListItemDTO> createShoppingListItemDTOList = new ArrayList<>();
        for (CreateShoppingListItemRequest createShoppingListItemRequest : createShoppingListRequest.getItems()) {
            Long itemIdDevice = createShoppingListItemRequest.getItemIdDevice();
            String itemName = createShoppingListItemRequest.getItemName();
            Boolean markedChecked = createShoppingListItemRequest.isChecked();
            String quantityDescription = createShoppingListItemRequest.getQuantityDescription();

            CreateShoppingListItemDTO createShoppingListItemDTO = new CreateShoppingListItemDTO(itemIdDevice, itemName, markedChecked, quantityDescription);
            createShoppingListItemDTOList.add(createShoppingListItemDTO);

        }
        return new CreateShoppingListDTO(createShoppingListRequest.getListIdDevice(), createShoppingListRequest.getListName(), createShoppingListItemDTOList);
    }
}
