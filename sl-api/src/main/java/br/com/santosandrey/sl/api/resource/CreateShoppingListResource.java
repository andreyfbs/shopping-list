package br.com.santosandrey.sl.api.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import br.com.santosandrey.sl.api.client.UserStoreService;
import br.com.santosandrey.sl.api.converter.CreateShoppingListDTOConverter;
import br.com.santosandrey.sl.api.converter.CreateShoppingListResponseConverter;
import br.com.santosandrey.sl.api.dto.CreateShoppingListRequest;
import br.com.santosandrey.sl.api.dto.CreateShoppingListResponse;
import br.com.santosandrey.sl.api.interceptor.TokenValidationRequired;
import br.com.santosandrey.sl.core.dto.CreateShoppingListInputDTO;
import br.com.santosandrey.sl.core.dto.CreateShoppingListOutputDTO;
import br.com.santosandrey.sl.core.service.CreateShoppingListService;

/**
 * Endpoints of Creation Lists
 */
@RestController
@TokenValidationRequired
public class CreateShoppingListResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateShoppingListResource.class);

    @Autowired
    private CreateShoppingListService createShoppingListService;

    @Autowired
    private CreateShoppingListResponseConverter createShoppingListResponseConverter;

    @Autowired
    private CreateShoppingListDTOConverter createShoppingListDTOConverter;

    @Autowired
    private UserStoreService userStoreService;

    /**
     * This endpoint is when the user wants to create a new List
     * @param accessToken
     * @param accountDeviceId
     * @param createShoppingListRequest
     * @return CreateShoppingListResponse - List Data after creation
     */
    @RequestMapping(method = RequestMethod.POST, value = EndPointURL.URL_SHOPPING_LIST)
    public ResponseEntity<CreateShoppingListResponse> createNewList(
            @RequestHeader(value = "X-Token-Session", required = true) final String accessToken,
            @RequestHeader(value = "X-Account-device-id", required = true) final String accountDeviceId,
            @RequestBody @Valid CreateShoppingListRequest createShoppingListRequest) {
        LOGGER.info("c=CreateShoppingListResource, m=createNewList, createShoppingListRequest={}", createShoppingListRequest);

        // Convert the Request to a VO in call the service
        CreateShoppingListOutputDTO createShoppingListOutputDTO = createShoppingListService.createNewList(new CreateShoppingListInputDTO(createShoppingListDTOConverter.convertFrom(createShoppingListRequest), userStoreService.retrieveUserId(accessToken), Long.valueOf(accountDeviceId)));

        CreateShoppingListResponse createShoppingListResponse = createShoppingListResponseConverter.convertFrom(createShoppingListOutputDTO);

        LOGGER.info("c=CreateShoppingListResource, m=createNewList, createShoppingListResponse={}", createShoppingListResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createShoppingListResponse);
    }
}