package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.UserEntity;

import java.sql.SQLException;

public class UserService {

    UserDao userDao = new UserDao();
    CredentialManagerDao = new CredentialManager();

    /*
    LOGIN: funzione che prende in ingresso email
	e password ed al click su accedi verifica esistenza
	e correttezza delle credenziali, restituirà oggetto Utente
     */
    public UserEntity login(String email, String password) throws SQLException {

        UserEntity utente = new UserEntity();
        utente = userDao.findByEmail(email);
        return utente;
    }


}
