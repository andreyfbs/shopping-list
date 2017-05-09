package br.com.santosandrey.sl.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateShoppingListItemRequest {

    @NotNull
    @Size(min = 1)
    @JsonProperty("item-id-device")
    private Long itemIdDevice;

    @NotNull
    @Size(min = 1)
    @JsonProperty("item-name")
    private String itemName;

    @NotNull
    @Size(min = 1)
    @JsonProperty("is-checked")
    private boolean checked;

    @NotNull
    @Size(min = 1)
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

    public String getQuantityDescription() {
        return quantityDescription;
    }

    public void setItemIdDevice(Long itemIdDevice) {
        this.itemIdDevice = itemIdDevice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantityDescription(String quantityDescription) {
        this.quantityDescription = quantityDescription;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "CreateShoppingListItemRequest{" +
                "itemIdDevice=" + itemIdDevice +
                ", itemName='" + itemName + '\'' +
                ", checked=" + checked +
                ", quantityDescription='" + quantityDescription + '\'' +
                '}';
    }
}