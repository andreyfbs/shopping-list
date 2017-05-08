package br.com.santosandrey.sl.api;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.santosandrey.sl.api.interceptor.TokenUserLoggedValidationInterceptor;

@Configuration
@EnableJpaRepositories("br.com.santosandrey.sl.repository")
@EntityScan("br.com.santosandrey.sl.model")
public class SlModelConfiguration {

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2/console/*");
        return registrationBean;
    }

}
