package com.example.propertiesvaluedemo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SystemMensage implements CommandLineRunner {
    @Autowired
    private Sender sender;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: "+sender.getName()
                +"\nEmail: "+sender.getEmail()
                +"\nCom telefone para contato: "+sender.getTel());
        System.out.println("Cadastro aprovado!");
    }
}

