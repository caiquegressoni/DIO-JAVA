package com.example.propertiesvaluedemo.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SystemMensage implements CommandLineRunner {
    @Value("${name}")
    private String name;
    @Value("${email}")
    private String email;
    @Value("${tel}")
    private List<Long> tel;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: "+name
                +"\nEmail: "+email
                +"\nCom telefone para contato: "+tel);
        System.out.println("Cadastro aprovado!");
    }
}

