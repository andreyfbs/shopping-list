package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateShoppingListRequest {

    @JsonProperty("list-id-device")
    private Long listIdDevice;

    @JsonProperty("list-name")
    private String listName;

    private List<CreateShoppingListItemRequest> items;

    public CreateShoppingListRequest() {
    }

    public Long getListIdDevice() {
        return listIdDevice;
    }

    public String getListName() {
        return listName;
    }

    public List<CreateShoppingListItemRequest> getItems() {
        return items;
    }
}
