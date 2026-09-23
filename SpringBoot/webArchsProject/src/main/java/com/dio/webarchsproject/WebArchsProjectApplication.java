package com.dio.webarchsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WebArchsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebArchsProjectApplication.class, args);
    }

}
