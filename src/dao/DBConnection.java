package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "admin";
    private final String PASSWORD = "admin";

    // Constructor privado
    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la instancia única
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}