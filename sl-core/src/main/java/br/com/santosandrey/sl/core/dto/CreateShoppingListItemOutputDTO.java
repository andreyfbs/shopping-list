package br.com.santosandrey.sl.core.dto;

public class CreateShoppingListItemOutputDTO {

    private final Long itemIdDevice;

    private final Long itemIdServer;

    public CreateShoppingListItemOutputDTO(Long itemIdDevice, Long itemIdServer) {
        this.itemIdDevice = itemIdDevice;
        this.itemIdServer = itemIdServer;
    }

    public Long getItemIdDevice() {
        return itemIdDevice;
    }

    public Long getItemIdServer() {
        return itemIdServer;
    }
}