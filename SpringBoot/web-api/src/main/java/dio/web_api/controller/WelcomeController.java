package dio.web_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcomeMessage(){
        return "Welcome to Spring Boot Web API!";
    }
}
