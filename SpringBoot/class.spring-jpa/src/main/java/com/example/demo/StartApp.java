package com.example.demo;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        UserModel user = new UserModel();
        user.setName("Teste");
        user.setUsername("teste.teste");
        user.setPassword("Teste@123");

        repository.save(user);

        for(UserModel um: repository.findAll()){
            System.out.println(um);
        }
    }
}
