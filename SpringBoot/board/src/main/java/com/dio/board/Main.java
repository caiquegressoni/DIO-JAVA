package com.dio.board;

import com.dio.board.percistence.migration.MigrationStrategy;

import java.sql.SQLException;

import static com.dio.board.percistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
