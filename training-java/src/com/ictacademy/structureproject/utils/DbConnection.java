package com.ictacademy.structureproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {

    public DbConnection() {};

        public Connection creaConnessione() {

            String url = "jdbc:mysql://localhost:3306/fidelityDB";
            Properties props = new Properties();
            props.setProperty("root", "fidelityDB");
            props.setProperty("admin", "fidelityDB");
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, props);
                System.out.println("Test di connessione avvenuto con successo");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        public boolean chiudiConnessione(Connection conn) throws SQLException {
            conn.close();
            return true;
        }
}
