package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateShoppingListItemRequest {

    @JsonProperty("item-id-device")
    private Long itemIdDevice;

    @JsonProperty("item-name")
    private String itemName;

    @JsonProperty("is-checked")
    private boolean isChecked;

    @JsonProperty("quantity-description")
    private String quantityDescription;

    public CreateShoppingListItemRequest() {
    }

    public Long getItemIdDevice() {
        return itemIdDevice;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getQuantityDescription() {
        return quantityDescription;
    }
}