package dio.spring_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping
    public String index() {
        return "Welcome to Home Page";
    }
    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('MANAGER', 'USER')")
    public String users(){
        return "Authorized user";
    }
    @GetMapping("/managers")
    @PreAuthorize("hasRole('MANAGER')")
    public String managers(){
        return "Authorized manager";
    }
}
