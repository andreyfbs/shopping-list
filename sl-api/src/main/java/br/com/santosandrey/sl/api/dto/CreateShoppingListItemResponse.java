package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateShoppingListItemResponse {

    @JsonProperty("item-id-server")
    private Long itemIdServer;

    @JsonProperty("item-id-device")
    private Long itemIdDevice;

    public CreateShoppingListItemResponse(Long itemIdServer, Long itemIdDevice) {
        this.itemIdServer = itemIdServer;
        this.itemIdDevice = itemIdDevice;
    }

    public CreateShoppingListItemResponse() {
    }

    public Long getItemIdServer() {
        return itemIdServer;
    }

    public Long getItemIdDevice() {
        return itemIdDevice;
    }
}