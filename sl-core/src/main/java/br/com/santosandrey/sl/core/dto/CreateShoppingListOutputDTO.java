package br.com.santosandrey.sl.core.dto;

import java.util.List;

public class CreateShoppingListOutputDTO {

    private final Long listIdServer;

    private final List<CreateShoppingListItemOutputDTO> createShoppingListItemOutputDTOList;

    public CreateShoppingListOutputDTO(Long listIdServer, List<CreateShoppingListItemOutputDTO> createShoppingListItemOutputDTOList) {
        this.listIdServer = listIdServer;
        this.createShoppingListItemOutputDTOList = createShoppingListItemOutputDTOList;
    }

    public List<CreateShoppingListItemOutputDTO> getCreateShoppingListItemOutputDTOList() {
        return createShoppingListItemOutputDTOList;
    }

    public Long getListIdServer() {
        return listIdServer;
    }
}