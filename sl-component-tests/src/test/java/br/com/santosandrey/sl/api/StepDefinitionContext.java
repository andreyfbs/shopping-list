package br.com.santosandrey.sl.api;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

@Component
@Scope("cucumber-glue")
public class StepDefinitionContext {

    private Long userId;

    private ResultActions resultActions;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ResultActions getResultActions() {
        return resultActions;
    }

    public void setResultActions(ResultActions resultActions) {
        this.resultActions = resultActions;
    }
}
