package com.ultra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = { "com.ultra" })
@RestController
public class SpringBootSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwagger2Application.class, args);
    }

}
