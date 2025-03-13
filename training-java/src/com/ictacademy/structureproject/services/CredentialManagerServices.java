package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CredentialManagerServices {

    private final CredentialManagerDao cmDAO;

    // Iniezione della dipendenza nel costruttore
    public CredentialManagerServices(CredentialManagerDao cm) {
        this.cmDAO = cmDAO;
    }

    public boolean cambiaPassword(int userId, String nuovaPassword, String vecchiaPassword, Timestamp dataRinnovo,) throws SQLException {
        // Validazione degli input

        if (nuovaPassword == null || vecchiaPassword == null || dataRinnovo == null) {
            throw new IllegalArgumentException("I parametri non possono essere nulli.");
        }

        // Verifica se la vecchia password è corretta
        if (!cmDAO.checkOldPassword(userId, vecchiaPassword)) {
            throw new SecurityException("La vecchia password non corrisponde.");
        }

        // Aggiorna le credenziali con la nuova password
        return cmDAO.updateCredential(userId, nuovaPassword, dataRinnovo,);
    }
}



