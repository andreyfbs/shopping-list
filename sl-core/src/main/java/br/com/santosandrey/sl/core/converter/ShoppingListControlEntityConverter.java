package br.com.santosandrey.sl.core.converter;

import org.springframework.stereotype.Component;

import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ShoppingListControlEntity;

@Component
public class ShoppingListControlEntityConverter {

    public ShoppingListControlEntity converterFrom(CreateShoppingListInputDTO createShoppingListInputDTO) {
        return new ShoppingListControlEntity();
    }

}
