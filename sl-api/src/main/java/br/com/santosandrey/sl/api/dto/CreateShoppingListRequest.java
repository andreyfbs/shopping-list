package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateShoppingListRequest {

    @NotNull
    @JsonProperty("list-id-device")
    private Long listIdDevice;

    @NotNull
    @Size(min = 1)
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

    @Override
    public String toString() {
        return "CreateShoppingListRequest{" +
                "listIdDevice=" + listIdDevice +
                ", listName='" + listName + '\'' +
                ", items=" + items +
                '}';
    }
}
