package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CredentialManagerServices {

    CredentialManagerDao cmDAO = new CredentialManagerDao();

    // Iniezione della dipendenza nel costruttore

    public CredentialManagerServices() {

    }

    public boolean cambiaPassword(int userId, String nuovaPassword, String vecchiaPassword, Timestamp dataRinnovo) throws SQLException {

        boolean result = false;


        // Validazione degli input

        if (nuovaPassword == null || vecchiaPassword == null || dataRinnovo == null) {
            throw new IllegalArgumentException("I parametri non possono essere nulli.");
        } else {
        // Verifica se la vecchia password è corretta
            if (!cmDAO.checkOldPassword(userId, vecchiaPassword)) {
                throw new SecurityException("La vecchia password non corrisponde.");
            } else {
                if(vecchiaPassword.equals(nuovaPassword)) {
                    throw new IllegalArgumentException("le password sono uguale");
                } else{
                  result = cmDAO.updateCredentialPassword(userId, nuovaPassword, dataRinnovo);;
                }
            }

        // Aggiorna le credenziali con la nuova password

        return result;
        }

    }
}



