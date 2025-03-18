package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.RoleDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

// Recupero Id utente
@Service
public class RoleService {

    @Autowired
    private UserDao userDao;

    public Optional<User> getUserById(Long id) {
        return userDao.findById(id);
    }

    RoleDao roleDao;
    // UserDao userDao = new UserDao();

    //Costruttore
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    //Creazione del nuovo ruolo
    public boolean addRole(Long idUser, String ruolo) throws SQLException {

        boolean res = false;

        // UserEntity user = new UserEntity();
        user = userDao.findById(idUser);
        if(user.getIdRuolo()!= 3){
            System.out.println("l'utente non ha il ruolo valido per eseguire l'operazione");
            return res;
        } else {
            boolean ruoloPresente = roleDao.findByNome(ruolo);
            if (ruoloPresente) {
                System.out.println("il ruolo esiste già");
                return false;
            } else {
                res = roleDao.RoleEntityCreate(ruolo);
                return res;
            }
        }
    }
}