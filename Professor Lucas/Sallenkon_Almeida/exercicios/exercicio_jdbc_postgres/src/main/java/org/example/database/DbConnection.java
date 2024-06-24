package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // bloqueio para a sincronização
    private static final Object lock = new Object();
    private static Connection connection = null;

    // metodo para obter o objeto de conexão
    public static Connection getConnection() {
        synchronized (lock) {
            try{
                // este bloco ira verificar se a conexão está fechada e tentará reabri-la caso haja necessidade
                if (connection == null || connection.isClosed()) {
                    String url = "jdbc:postgresql://localhost:5432/locadora1";
                    String user = "postgres";
                    String password = "postgres";
                    connection = DriverManager.getConnection(url, user, password);
                }
            }catch(SQLException e){
                throw new RuntimeException("Não foi possível conectar-se ao banco de dados! " + e);
            }
        }
        return connection;
    }
}
