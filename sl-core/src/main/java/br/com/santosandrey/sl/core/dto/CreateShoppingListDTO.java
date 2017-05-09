package br.com.santosandrey.sl.core.dto;

import java.util.List;

public class CreateShoppingListDTO {

    private final Long listIdDevice;

    private final String listName;

    private final List<CreateShoppingListItemDTO> items;

    public CreateShoppingListDTO(Long listIdDevice, String listName, List<CreateShoppingListItemDTO> items) {
        this.listIdDevice = listIdDevice;
        this.listName = listName;
        this.items = items;
    }

    public Long getListIdDevice() {
        return listIdDevice;
    }

    public String getListName() {
        return listName;
    }

    public List<CreateShoppingListItemDTO> getItems() {
        return items;
    }
}
