package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.UserEntity;

import java.sql.SQLException;
import java.sql.Timestamp;

public class UserService {

    UserDao userDao = new UserDao();
    CredentialManagerDao credentialManagerDao = new CredentialManagerDao();

    /*
    LOGIN: funzione che prende in ingresso email
	e password ed al click su accedi verifica esistenza
	e correttezza delle credenziali, restituirà oggetto Utente
     */
    public UserEntity login(String email, String password) throws SQLException {


        UserEntity utente = userDao.findByEmail(email);

        if(utente != null) {
            System.out.println("esiste l'utente con mail"+ email);
            long idUtente = utente.getIdUtente();
            String psw = credentialManagerDao.findByPswAndIdUtente(password, idUtente);
            if(psw != null) {
                System.out.println("la password coincide");
                return utente;
            } else {
                System.out.println("la password non coincide");
                return null;
            }
        } else {
            return null;
        }
    }

    public boolean registration(String nome, String cognome, String email, Timestamp dataNascita) throws SQLException {

        UserEntity utente = userDao.findByEmail(email);
        boolean accountCreated;
        if(utente != null){
            System.out.println("L'utenza esiste già.");
            return accountCreated = false;
        }
        accountCreated = userDao.createUser(nome, cognome, email, dataNascita);
        return accountCreated;

    }


}
