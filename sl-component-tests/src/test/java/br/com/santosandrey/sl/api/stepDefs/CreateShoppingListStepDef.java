package br.com.santosandrey.sl.api.stepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.santosandrey.sl.api.SlApiApplication;
import br.com.santosandrey.sl.api.dto.CreateShoppingListItemRequest;
import br.com.santosandrey.sl.api.dto.CreateShoppingListRequest;
import br.com.santosandrey.sl.api.resource.EndPointURL;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest("server.port:0")
@ContextConfiguration(classes = {SlApiApplication.class}, loader = SpringBootContextLoader.class)
public class CreateShoppingListStepDef {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private ResultActions resultActions;

    private CreateShoppingListRequest createShoppingListRequest;

    private HttpHeaders httpHeaders;

    @Before
    public void commonSetup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        createShoppingListRequest = new CreateShoppingListRequest();
        httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Token-Session", "1cae11ac-f3cd-437a-9a00-a4a4a2715dc0");
        httpHeaders.set("X-Account-device-id", "1");
    }

    @Given("^the new list$")
    public void the_new_list(Map<String, String> mapListRequest) throws Throwable {
        createShoppingListRequest.setListIdDevice(Long.valueOf(mapListRequest.get("list-id-device")));
        createShoppingListRequest.setListName(mapListRequest.get("list-name"));
    }

    @Given("^the items$")
    public void the_items(List<Map<String, String>> listItemsMap) throws Throwable {

        List<CreateShoppingListItemRequest> createShoppingListItemRequestList = new ArrayList<>();
        for (Map<String, String> itemMap : listItemsMap) {
            CreateShoppingListItemRequest createShoppingListItemRequest = new CreateShoppingListItemRequest();
            createShoppingListItemRequest.setItemIdDevice(Long.valueOf(itemMap.get("item-id-device")));
            createShoppingListItemRequest.setItemName(itemMap.get("item-name"));
            createShoppingListItemRequest.setChecked(Boolean.valueOf(itemMap.get("is-checked")));
            createShoppingListItemRequest.setQuantityDescription(itemMap.get("quantity-description"));
            createShoppingListItemRequestList.add(createShoppingListItemRequest);
        }
        createShoppingListRequest.setItems(createShoppingListItemRequestList);

    }

    @When("^I click to create a new List$")
    public void i_click_to_create_a_new_List() throws Throwable {

        String jsonRequest = new ObjectMapper().writeValueAsString(createShoppingListRequest);
        resultActions = mockMvc.perform(MockMvcRequestBuilders.post(EndPointURL.URL_SHOPPING_LIST).headers(httpHeaders).content(jsonRequest).contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Then("^the returned status is (\\d+)$")
    public void the_returned_status_is(int status) throws Throwable {

        resultActions.andExpect(MockMvcResultMatchers.status().is(status));
    }

    @Then("^the list-id-server is (\\d+)$")
    public void the_list_id_server_is(int arg1) throws Throwable {

    }

    @Then("^the items are$")
    public void the_items_are(List<Map<String, String>> data) throws Throwable {

    }
}
