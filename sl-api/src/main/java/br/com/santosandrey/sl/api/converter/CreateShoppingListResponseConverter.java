package br.com.santosandrey.sl.api.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import br.com.santosandrey.sl.api.dto.CreateShoppingListItemResponse;
import br.com.santosandrey.sl.api.dto.CreateShoppingListResponse;
import br.com.santosandrey.sl.model.ShoppingListEntity;

@Component
public class CreateShoppingListResponseConverter {

    public CreateShoppingListResponse convertFrom(ShoppingListEntity shoppingListEntity) {
        List<CreateShoppingListItemResponse> createShoppingListItemResponseList = new ArrayList<>();
        return new CreateShoppingListResponse(9L, createShoppingListItemResponseList);
    }
}
