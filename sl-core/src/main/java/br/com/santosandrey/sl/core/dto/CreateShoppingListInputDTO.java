package br.com.santosandrey.sl.core.dto;

import br.com.santosandrey.sl.api.dto.CreateShoppingListRequest;

public class CreateShoppingListInputDTO {

    private final CreateShoppingListRequest createShoppingListRequest;

    private final Long userId;

    private final Long accountDeviceId;

    public CreateShoppingListInputDTO(CreateShoppingListRequest createShoppingListRequest, Long userId, Long accountDeviceId) {
        this.createShoppingListRequest = createShoppingListRequest;
        this.userId = userId;
        this.accountDeviceId = accountDeviceId;
    }

    public CreateShoppingListRequest getCreateShoppingListRequest() {
        return createShoppingListRequest;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountDeviceId() {
        return accountDeviceId;
    }
}