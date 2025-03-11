package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.CredentialManagerDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.UserEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.SQLException;

public class UserService {

    UserDao userDao = new UserDao();
    CredentialManagerDao credentialManagerDao = new CredentialManagerDao();

    /*
    LOGIN: funzione che prende in ingresso email
	e password e al click su accedi verifica esistenza
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
    // Registrazione Utente
    public boolean Registration(String emailToFind, UserEntity newUser) throws SQLException {
        // Crea connessione
        DbConnection dbConnection = new DbConnection();
        UserEntity utente = userDao.findByEmail(emailToFind);
        boolean AccountCreate;
        if (utente != null){
            System.out.println("L'utente esiste gia.\n");
            return AccountCreate = false;
        }

        // prende CreateUser in dao
        AccountCreate = userDao.createUser(newUser.getNome(),newUser.getCognome(),newUser.getEmail(),newUser.getDataNascita());
        return AccountCreate;

        // Vecchio metodo
//        Connection conn = dbConnection.creaConnessione();
//        PreparedStatement ps = conn.prepareStatement("insert into User (idUtente ,id_role ,nome ,cognome ,email ,dataNascita ,flagCancellato) VALUES (?, ?, ?, ?; ?; ?, ?");
//        ps.setLong(1, newUser.getIdUtente());
//        ps.setLong(2, newUser.getIdRuolo());
//        ps.setString(3, newUser.getNome());
//        ps.setString(4, newUser.getCognome());
//        ps.setString(5, newUser.getEmail());
//        ps.setTimestamp(6, newUser.getDataNascita());
//        ps.setBoolean(7, newUser.isFlagCancellato());
//        int rs = ps.executeUpdate();
//        conn.close();
    }
}
