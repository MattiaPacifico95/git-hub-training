package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;

import com.ictacademy.structureproject.daos.RoleDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.RoleEntity;
import com.ictacademy.structureproject.entities.UserEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    DbConnection dbConnection = new DbConnection();
    UserDao userDao = new UserDao();
    RoleDao roleDao = new RoleDao();
    CredentialManagerDao credentialManagerDao = new CredentialManagerDao();

    public UserService() {
    }

    /*

        LOGIN: funzione che prende in ingresso email
        e password ed al click su accedi verifica esistenza
        e correttezza delle credenziali, restituirà oggetto Utente
         */

    /*
    LOGIN: funzione che prende in ingresso email
    e password ed al click su accedi verifica esistenza
    e correttezza delle credenziali, restituirà oggetto Utente
     */

        public UserEntity login(String email, String password) throws SQLException {


            UserEntity utente = userDao.findByEmail(email);

            if (utente != null) {
                System.out.println("esiste l'utente con mail" + email);
                long idUtente = utente.getIdUtente();

                String psw = credentialManagerDao.findByPswAndIdUtente(password, idUtente);

                if (psw != null) {
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

        public boolean registration(UserEntity newUser, String email) throws SQLException {
            boolean accountCreated;
            UserEntity utente = new UserEntity();
            if (utente != null) {
                System.out.println("la utente esiste di già");
                return accountCreated = false;
            }

            accountCreated = userDao.createUser(newUser.getNome(), newUser.getCognome(), newUser.getEmail(), newUser.getDataNascita());
            return accountCreated;

        }


    }


