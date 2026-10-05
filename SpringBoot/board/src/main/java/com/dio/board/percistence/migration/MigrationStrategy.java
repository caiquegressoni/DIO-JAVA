package com.dio.board.percistence.migration;

import lombok.RequiredArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;

@RequiredArgsConstructor
public class MigrationStrategy {
    private final Connection connection;

    private void executeMigration(){
        var originalOut = System.out;
        var originalErr =  System.err;
        try{
            try(var fos = new FileOutputStream("Liquibase.log")){
                System.setOut(new PrintStream(fos));
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}
