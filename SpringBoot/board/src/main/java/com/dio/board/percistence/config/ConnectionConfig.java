package com.dio.board.percistence.config;

import static lombok.AccessLevel.PRIVATE;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {
    public static Connection getConnection() throws SQLException {
        var url = "jdbc:mysql://localhost:3306/board";
        var user = "root";
        var password = "MinhaSenha123";
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }

}
