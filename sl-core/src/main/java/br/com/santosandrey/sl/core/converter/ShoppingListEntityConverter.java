package br.com.santosandrey.sl.core.converter;

import org.springframework.stereotype.Component;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ShoppingListEntity;

@Component
public class ShoppingListEntityConverter {

    public ShoppingListEntity converterFrom(CreateShoppingListInputDTO createShoppingListInputDTO) {
        return new ShoppingListEntity();
    }

}
