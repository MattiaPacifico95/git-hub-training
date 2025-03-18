package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.UserDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao=userDao;
    }

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
