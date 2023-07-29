package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        String connectionUrl = "jdbc:h2:./db";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getSqlFromFile(String path) {
        try {
            return  String.join("\n",
                    Files.readAllLines(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate(String script) {
        try {
            INSTANCE.getConnection().createStatement().executeUpdate(script);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
