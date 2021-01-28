package ru.otus.architect.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void post() {
        System.err.println("SWAGGER: http://localhost:8080/swagger-ui/index.html");
    }

}
