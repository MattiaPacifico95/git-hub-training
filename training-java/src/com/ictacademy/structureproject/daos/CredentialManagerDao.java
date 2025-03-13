package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CredentialManagerEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialManagerDao {

    DbConnection dbConnection = new DbConnection();

    public CredentialManagerEntity findCredentialById (long idCm) throws SQLException {
        CredentialManagerEntity credential = new CredentialManagerEntity();
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CREDENTIAL_MANAGER where id_CredentialManager = ?");
        ps.setLong(1, idCm);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            credential.setIdCm(rs.getLong("id_CredentialManager"));
            credential.setPsw(rs.getString("password"));
            credential.setDataCreazione(rs.getTimestamp("data_creazione"));
            credential.setIdUtente(rs.getLong("id_Utente"));
            credential.setDataRinnovo(rs.getTimestamp("data_rinnovo"));
        }
       conn.close();
       return credential;
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

        List<CredentialManagerEntity> lista = new ArrayList<CredentialManagerEntity>();
        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CREDENTIAL_MANAGER");
        while (rs.next()) {
            CredentialManagerEntity credential = new CredentialManagerEntity();
            credential.setIdCm(rs.getLong("id_CredentialManager"));
            credential.setPsw(rs.getString("password"));
            credential.setDataCreazione(rs.getTimestamp("data_creazione"));
            credential.setIdUtente(rs.getLong("id_Utente"));
            credential.setDataRinnovo(rs.getTimestamp("data_rinnovo"));
            lista.add(credential);
        }
        conn.close();
        return lista;
    }


    // insert into credential_manager (password, id_utente, data_rinnovo) values (?,?,?)
    public boolean createCredential(String password, long idUtente, Timestamp dataRinnovo) throws SQLException {
        boolean res;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into credential_manager (password, id_utente, data_rinnovo) values (?,?,?)");
        ps.setString(1, password);
        ps.setLong(2, idUtente);
        ps.setTimestamp(3, dataRinnovo);
        int rs = ps.executeUpdate();
        if(rs >0 ){
            res = true;
        } else {
            res = false;
        }
        conn.close();
        return res;
    }

    // update Credential_manager set password = ?, data_rinnovo = ? where id_credential = ?
    public boolean updateCredential(String password, Timestamp dataRinnovo, long idCm) throws SQLException {
        boolean res;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("update credential_manager set password=?, data_rinnovo = ? where id_CredentialManager=?");
        ps.setString(1, password);
        ps.setTimestamp(2, dataRinnovo);
        ps.setLong(3, idCm);
        int rs = ps.executeUpdate();
        if(rs >0 ){
            res = true;
        } else {
            res = false;
        }
        conn.close();
        return res;
    }

    // delete from credential_manager where id_credentialmanager = ?
    public boolean deleteCredential(long idCm) throws SQLException {
        boolean res;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("delete from credential_manager where id_CredentialManager=?");
        ps.setLong(1, idCm);
        int rs = ps.executeUpdate();
        if(rs >0 ){
            res = true;
        } else {
            res = false;
        }
        conn.close();
        return res;

    }
}

