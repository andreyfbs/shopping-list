package br.com.santosandrey.sl.core.dto;

public class CreateShoppingListItemDTO {

    private final Long itemIdDevice;

    private final String itemName;

    private final boolean checked;

    private final String quantityDescription;

    public CreateShoppingListItemDTO(Long itemIdDevice, String itemName, boolean checked, String quantityDescription) {
        this.itemIdDevice = itemIdDevice;
        this.itemName = itemName;
        this.checked = checked;
        this.quantityDescription = quantityDescription;
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

    public boolean isChecked() {
        return checked;
    }
}