package br.com.santosandrey.sl.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import br.com.santosandrey.sl.api.resource.CreateShoppingListResource;
import br.com.santosandrey.sl.core.converter.ItemEntityConverter;
import br.com.santosandrey.sl.core.converter.ShoppingListControlEntityConverter;
import br.com.santosandrey.sl.core.converter.ShoppingListEntityConverter;
import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.model.ItemEntity;
import br.com.santosandrey.sl.model.ShoppingListControlEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;
import br.com.santosandrey.sl.repository.ItemRepository;
import br.com.santosandrey.sl.repository.ShoppingListControlRepository;
import br.com.santosandrey.sl.repository.ShoppingListRepository;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateShoppingListResource.class);

    @Autowired
    private ShoppingListEntityConverter shoppingListEntityConverter;

    @Autowired
    private ShoppingListControlEntityConverter shoppingListControlEntityConverter;

    @Autowired
    private ItemEntityConverter itemEntityConverter;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingListControlRepository shoppingListControlRepository;

    @Override
    @Transactional
    public void createNewList(final CreateShoppingListInputDTO createShoppingListInputDTO) {

        final ShoppingListEntity shoppingListEntity = shoppingListEntityConverter.converterFrom(createShoppingListInputDTO);
        final ShoppingListEntity shoppingListPersisted = shoppingListRepository.save(shoppingListEntity);

        final List<ItemEntity> itemEntityList = itemEntityConverter.converterFrom(createShoppingListInputDTO, shoppingListPersisted);

        for (ItemEntity itemEntity : itemEntityList) {
            itemRepository.save(itemEntity);
        }

        final ShoppingListControlEntity shoppingListControlEntity = shoppingListControlEntityConverter.converterFrom(createShoppingListInputDTO, shoppingListPersisted);
        ShoppingListControlEntity shoppingListControlPersisted = shoppingListControlRepository.save(shoppingListControlEntity);

        LOGGER.info(shoppingListPersisted.toString());
        LOGGER.info(shoppingListControlPersisted.toString());
    }
}