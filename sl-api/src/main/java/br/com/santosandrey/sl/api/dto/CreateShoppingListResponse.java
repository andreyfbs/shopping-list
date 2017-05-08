package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateShoppingListResponse {

    @JsonProperty("list-id-server")
    private Long listIdServer;

    private List<CreateShoppingListItemResponse> items;

    public CreateShoppingListResponse(Long listIdServer, List<CreateShoppingListItemResponse> items) {
        this.listIdServer = listIdServer;
        this.items = items;
    }

    public Long getListIdServer() {
        return listIdServer;
    }

    public List<CreateShoppingListItemResponse> getItems() {
        return items;
    }
}