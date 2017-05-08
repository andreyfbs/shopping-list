package br.com.santosandrey.sl.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.santosandrey.sl.core.converter.ShoppingListControlEntityConverter;
import br.com.santosandrey.sl.core.converter.ShoppingListEntityConverter;
import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ShoppingListControlEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;
import br.com.santosandrey.sl.repository.ShoppingListControlRepository;
import br.com.santosandrey.sl.repository.ShoppingListRepository;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    @Autowired
    private ShoppingListEntityConverter shoppingListEntityConverter;

    @Autowired
    private ShoppingListControlEntityConverter shoppingListControlEntityConverter;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private ShoppingListControlRepository shoppingListControlRepository;

    @Override
    @Transactional
    public void createNewList(final CreateShoppingListInputDTO createShoppingListInputDTO) {

        final ShoppingListEntity shoppingListEntity = shoppingListEntityConverter.converterFrom(createShoppingListInputDTO);

        final ShoppingListControlEntity shoppingListControlEntity = shoppingListControlEntityConverter.converterFrom(createShoppingListInputDTO);

        shoppingListRepository.save(shoppingListEntity);

        shoppingListControlRepository.save(shoppingListControlEntity);

    }
}