package br.com.santosandrey.sl.api.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import br.com.santosandrey.sl.api.dto.CreateShoppingListItemResponse;
import br.com.santosandrey.sl.api.dto.CreateShoppingListResponse;
import br.com.santosandrey.sl.core.dto.CreateShoppingListItemOutputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListOutputDTO;

@Component
public class CreateShoppingListResponseConverter {

    public CreateShoppingListResponse convertFrom(CreateShoppingListOutputDTO createShoppingListOutputDTO) {
        List<CreateShoppingListItemResponse> createShoppingListItemResponseList = new ArrayList<>();
        for (CreateShoppingListItemOutputDTO createShoppingListItemOutputDTO : createShoppingListOutputDTO.getCreateShoppingListItemOutputDTOList()) {
            CreateShoppingListItemResponse createShoppingListItemResponse = new CreateShoppingListItemResponse(createShoppingListItemOutputDTO.getItemIdServer(), createShoppingListItemOutputDTO.getItemIdDevice());
            createShoppingListItemResponseList.add(createShoppingListItemResponse);
        }
        return new CreateShoppingListResponse(createShoppingListOutputDTO.getListIdServer(), createShoppingListItemResponseList);
    }
}
