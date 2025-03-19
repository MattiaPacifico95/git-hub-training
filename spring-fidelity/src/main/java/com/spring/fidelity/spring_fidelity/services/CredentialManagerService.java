package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.CredentialManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;

@Service
public class CredentialManagerService {

    private CredentialManagerDao cmDAO;

    @Autowired
    public CredentialManagerService(CredentialManagerDao cmDAO) {
        this.cmDAO = cmDAO;
    }


    public boolean cambiaPassword(int userId, String nuovaPassword, String vecchiaPassword, Timestamp dataRinnovo) throws SQLException {
//        if (nuovaPassword == null || vecchiaPassword == null || dataRinnovo == null) {
//            throw new IllegalArgumentException("I parametri non possono essere nulli.");
//        }

        if (cmDAO.checkOldPassword(userId, vecchiaPassword) == 0) {
            throw new SecurityException("La vecchia password non corrisponde.");
        }

        if (vecchiaPassword.equals(nuovaPassword)) {
            throw new IllegalArgumentException("Le password sono uguali.");
        }
        cmDAO.updateOldPassword(userId, nuovaPassword, dataRinnovo);

        return true;
    }
}
