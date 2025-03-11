package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.UserEntity;

import java.sql.SQLException;

public class UserService {

    UserDao userDao = new UserDao();
    CredentialManagerDao cmDAO = new CredentialManagerDao();

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
            String psw = cmDAO.findByPswAndIdUtente(password, idUtente);
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
    public boolean registration (UserEntity newUser,String email) throws SQLException {
        boolean accountCreated;
        UserEntity utente = new UserEntity();
        if (utente!=null){
            System.out.println("la utente esiste di già");
            return accountCreated=false;
        }

        accountCreated=userDao.createUser(newUser.getNome(),newUser.getCognome(),newUser.getEmail(),newUser.getDataNascita());
        return accountCreated;

    }


}