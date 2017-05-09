package br.com.santosandrey.sl.api;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Config to Spring Data
 */
@Configuration
@EnableJpaRepositories("br.com.santosandrey.sl.repository")
@EntityScan("br.com.santosandrey.sl.model")
public class SlModelConfiguration {

    /**
     * Console H2
     * @return
     */
    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2/console/*");
        return registrationBean;
    }
}
