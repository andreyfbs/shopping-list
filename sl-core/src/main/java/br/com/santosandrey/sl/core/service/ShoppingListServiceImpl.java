package br.com.santosandrey.sl.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import br.com.santosandrey.sl.core.converter.ItemEntityConverter;
import br.com.santosandrey.sl.core.converter.ShoppingListControlEntityConverter;
import br.com.santosandrey.sl.core.converter.ShoppingListEntityConverter;
import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListItemOutputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListOutputDTO;
import br.com.santosandrey.sl.model.ItemEntity;
import br.com.santosandrey.sl.model.ShoppingListControlEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;
import br.com.santosandrey.sl.repository.ItemRepository;
import br.com.santosandrey.sl.repository.ShoppingListControlRepository;
import br.com.santosandrey.sl.repository.ShoppingListRepository;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

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
    public CreateShoppingListOutputDTO createNewList(final CreateShoppingListInputDTO createShoppingListInputDTO) {

        final ShoppingListEntity shoppingListEntity = shoppingListEntityConverter.converterFrom(createShoppingListInputDTO);
        final ShoppingListEntity shoppingListPersisted = shoppingListRepository.save(shoppingListEntity);

        final List<ItemEntity> itemEntityList = itemEntityConverter.converterFrom(createShoppingListInputDTO, shoppingListPersisted);

        List<CreateShoppingListItemOutputDTO> createShoppingListItemOutputDTOList = new ArrayList<>();
        for (ItemEntity itemEntity : itemEntityList) {
            ItemEntity itemEntityPersisted = itemRepository.save(itemEntity);
            CreateShoppingListItemOutputDTO createShoppingListItemOutputDTO = new CreateShoppingListItemOutputDTO(itemEntity.getIdDevice(), itemEntityPersisted.getId());
            createShoppingListItemOutputDTOList.add(createShoppingListItemOutputDTO);
        }

        final ShoppingListControlEntity shoppingListControlEntity = shoppingListControlEntityConverter.converterFrom(createShoppingListInputDTO, shoppingListPersisted);
        shoppingListControlRepository.save(shoppingListControlEntity);

        return new CreateShoppingListOutputDTO(shoppingListPersisted.getId(), createShoppingListItemOutputDTOList);
    }
}