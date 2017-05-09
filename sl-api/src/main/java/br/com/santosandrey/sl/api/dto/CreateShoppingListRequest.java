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

    public void setListIdDevice(Long listIdDevice) {
        this.listIdDevice = listIdDevice;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setItems(List<CreateShoppingListItemRequest> items) {
        this.items = items;
    }
}
