package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CredentialManagerEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CredentialManagerDao {

    DbConnection dbConnection = new DbConnection();




    public CredentialManagerEntity findCredentialById (long id) throws SQLException {
        CredentialManagerEntity credential = new CredentialManagerEntity();
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CREDENTIAL_MANAGER where id_CredentialManager = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            Credential.setid_cm(rs.getLong("id_cm"));
            Credential.setiftente(rs.getString("id_utente"));
            Credential.setemailgetString("email"));
        java.util.Date dataCreazione;  // data_creazione
        Date dataRinnovo;

       conn.close();

       return user;
}
        }

