package br.com.santosandrey.sl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.santosandrey.sl")
public class SlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlApiApplication.class, args);
    }
}
