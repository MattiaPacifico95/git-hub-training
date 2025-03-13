package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CredentialManagerEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialManagerDao {

    private final DbConnection dbConnection = new DbConnection();

    public CredentialManagerEntity findCredentialById(long idCm) throws SQLException {
        String query = "SELECT * FROM CREDENTIAL_MANAGER WHERE id_CredentialManager = ?";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setLong(1, idCm);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CredentialManagerEntity(
                            rs.getLong("id_CredentialManager"),
                            rs.getString("password"),
                            rs.getTimestamp("data_creazione"),
                            rs.getLong("id_Utente"),
                            rs.getTimestamp("data_rinnovo")
                    );
                }
            }
        }
        return null;
    }


    // select * from credential_manager where password = ? and id_utente = ?
    public String findByPswAndIdUtente(String psw, long idUtente) throws SQLException {
        String password = "";
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from credential_manager where password = ? and id_utente = ?");
        ps.setString(1, psw);
        ps.setLong(2, idUtente);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            password = rs.getString("password");
        }
        conn.close();
        return password;
    }

    // select * from Credential_manager

    public List<CredentialManagerEntity> findAll() throws SQLException {
        List<CredentialManagerEntity> lista = new ArrayList<>();
        String query = "SELECT * FROM CREDENTIAL_MANAGER";
        try (Connection conn = dbConnection.creaConnessione();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                lista.add(new CredentialManagerEntity(
                        rs.getLong("id_CredentialManager"),
                        rs.getString("password"),
                        rs.getTimestamp("data_creazione"),
                        rs.getLong("id_Utente"),
                        rs.getTimestamp("data_rinnovo")
                ));
            }
        }
        return lista;
    }

    public boolean createCredential(String password, long idUtente, Timestamp dataRinnovo) throws SQLException {
        String query = "INSERT INTO credential_manager (password, id_utente, data_rinnovo) VALUES (?, ?, ?)";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, password);
            ps.setLong(2, idUtente);
            ps.setTimestamp(3, dataRinnovo);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateCredential(int userId, String password, Timestamp dataRinnovo, long idCm) throws SQLException {
        String query = "UPDATE credential_manager SET password = ?, data_rinnovo = ? WHERE id_CredentialManager = ?";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, password);
            ps.setTimestamp(2, dataRinnovo);
            ps.setLong(3, idCm);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteCredential(long idCm) throws SQLException {
        String query = "DELETE FROM credential_manager WHERE id_CredentialManager = ?";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setLong(1, idCm);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean checkOldPassword(int userId, String vecchiaPassword) throws SQLException {
        String query = "SELECT COUNT(*) FROM credential_manager WHERE id_utente = ? AND password = ?";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, vecchiaPassword);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public boolean updateCredentialPassword(int userId, String newPassword, Timestamp dataRinnovo) throws SQLException {
        String query = "UPDATE credential_manager SET password = ?, data_rinnovo = ? WHERE id_utente = ?";
        try (Connection conn = dbConnection.creaConnessione();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newPassword);
            ps.setTimestamp(2, dataRinnovo);
            ps.setInt(3, userId);
            return ps.executeUpdate() > 0;
        }
    }

}

