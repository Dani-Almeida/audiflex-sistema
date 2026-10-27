package br.com.audiflex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
        "jdbc:mysql://localhost:3306/audiflex";
    
    private static final String USUARIO = "root";

    private static final String SENHA =
        System.getenv("AUDIFLEX_DB_PASSWORD");
    

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);

    }    
}
