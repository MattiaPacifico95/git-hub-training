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

    /////// prova da Aldo di LOGOUT
    /*public boolean register(String nome, String cognome, String email, Timestamp data_nascita, String psw, String Npsw) throws SQLException {
        boolean created;
        UserEntity utente = new UserEntity();
        UserDao userDao = new UserDao();
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(nome + cognome + "@gmail.com");
        utente.setDataNascita(data_nascita);
        psw = "password";
        Npsw = "password";
        created = userDao.createUser(nome,cognome,email,data_nascita);
        if(created) {
            return true;
        }
        else {
            return false;
        }




        /*if(utente.getEmail().equals(email)) {

        }
        //utente.setDataNascita(data_nascita);
        return true;*/
    //}

    /////// prova da Aldo di LOGOUT
    /*public UserEntity logout(UserEntity ue,UserDao op) throws SQLException {
        long id = ue.getIdUtente();
        ue.setFlagCancellato(true);
        boolean flag = ue.isFlagCancellato();

        UserEntity utente = new UserEntity();
        //long id = utente.getIdUtente();
        return utente;
    }*/
    ////// Con la classe
    /// se idRuolo è  0 = dev , 1 = admin , 2 = utente
    public boolean Registration(String  emailToFind, UserEntity newUser) throws SQLException {
        boolean accountCreated;
        UserEntity utente = userDao.findByEmail(emailToFind);
        if (utente!=null){
            System.out.println("l'utente esiste di già.");
            return accountCreated=false;
        }
        accountCreated = userDao.createUser(newUser.getNome(), newUser.getCognome(), newUser.getEmail(), newUser.getDataNascita());
        utente = userDao.findByEmail(emailToFind);
        utente.setIdRuolo(2);

        return accountCreated;
    }
    public Map<Long, Integer> addToCart(List<ProdottoEntity> prodottiSelezionati, UserEntity user){

        Map<Long, Integer> cart = new HashMap<Long, Integer>();

        if(prodottiSelezionati==null){
            System.out.println("nessun prodotto selezionato");
            return new HashMap<>();
        } else {
            for(ProdottoEntity prodotto : prodottiSelezionati) {
                Long idProdotto = prodotto.getIdProdotto();
                Integer punti = prodotto.getPunti();
                cart.put(idProdotto, punti);
            }

            return cart;
        }
    }

}