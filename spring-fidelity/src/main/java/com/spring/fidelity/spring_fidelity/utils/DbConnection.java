package com.spring.fidelity.spring_fidelity.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {

    public DbConnection() {};

        public Connection creaConnessione() {

            String url = "jdbc:mysql://localhost:3306/fidelity_project";
            Properties props = new Properties();
            props.setProperty("root", "fidelity_project");
            props.setProperty("admin", "fidelity_project");
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
