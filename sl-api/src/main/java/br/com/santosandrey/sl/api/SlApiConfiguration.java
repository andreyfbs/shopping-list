package br.com.santosandrey.sl.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.santosandrey.sl.api.interceptor.TokenUserLoggedValidationInterceptor;

@Configuration
public class SlApiConfiguration extends WebMvcConfigurerAdapter {

    /**
     * Validation token to the User
     */
    @Bean
    public TokenUserLoggedValidationInterceptor tokenValidatorUserAuthenticationInterceptor() {
        return new TokenUserLoggedValidationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenValidatorUserAuthenticationInterceptor());
    }

}
