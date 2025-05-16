
package com.cinerama.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://" +
            System.getenv("DB_HOST") + ":" +
            System.getenv("DB_PORT") + "/" +
            System.getenv("DB_NAME") +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    private static final String USER = System.getenv("DB_USER");
    private static final String PASS = System.getenv("DB_PASS");

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver MySQL
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}