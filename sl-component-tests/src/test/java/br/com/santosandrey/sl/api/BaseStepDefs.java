package br.com.santosandrey.sl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest("server.port:0")
@ContextConfiguration(classes = {SlApiApplication.class}, loader = SpringBootContextLoader.class)
@ActiveProfiles("test-build")
public class BaseStepDefs {

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    protected ResultActions resultActions;

    @Autowired
    protected StepDefinitionContext stepDefinitionContext;

    protected void commonSetup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected void expectAllJsonElementsFromMap(Map<String, ?> mapJsonElements, Optional<String> keyArrayPrefix) {

        mapJsonElements.forEach((key, value) -> {
            final String jsonParameterName = keyArrayPrefix.isPresent() ? keyArrayPrefix.get() + key : key;
            try {
                resultActions.andExpect(jsonPath(jsonParameterName, is(value)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    protected ResultMatcher getMatcherErrorMessage(String message) {
        return jsonPath("$.errors[0].message", is(message));
    }

    protected ResultMatcher getMatcherErrorCode(String code) {
        return jsonPath("$.errors[0].code", is(code));
    }

    protected void executeRequest(RequestBuilder requestBuilder) throws Exception {
        // When
        resultActions = mockMvc.perform(requestBuilder);

        // Set the result in Context
        stepDefinitionContext.setResultActions(resultActions);

    }

}