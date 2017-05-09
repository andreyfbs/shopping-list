package br.com.santosandrey.sl.core.dto;

public class CreateShoppingListInputDTO {

    private final CreateShoppingListDTO createShoppingListDTO;

    private final Long userId;

    private final Long accountDeviceId;

    public CreateShoppingListInputDTO(CreateShoppingListDTO createShoppingListDTO, Long userId, Long accountDeviceId) {
        this.createShoppingListDTO = createShoppingListDTO;
        this.userId = userId;
        this.accountDeviceId = accountDeviceId;
    }

    public CreateShoppingListDTO getCreateShoppingListDTO() {
        return createShoppingListDTO;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountDeviceId() {
        return accountDeviceId;
    }
}