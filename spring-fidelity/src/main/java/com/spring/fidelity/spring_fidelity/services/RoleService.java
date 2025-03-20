package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.RoleDao;
import com.spring.fidelity.spring_fidelity.daos.UserDao;
import com.spring.fidelity.spring_fidelity.model.entities.RoleEntity;
import com.spring.fidelity.spring_fidelity.model.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

// Recupero Id utente
@Service
public class RoleService {

    RoleDao roleDao;
    UserDao userDao;

    //Costruttore
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    // Creazione del nuovo ruolo
    public boolean addRole(Long idUser, String ruolo) throws SQLException {

        boolean res = false;

        // UserEntity user = new UserEntity();
        // user = userDao.findById(idUser);
        UserEntity utenteTrovato = userDao.findBy(idUser);
        if(utenteTrovato.getIdRuolo() != 3) {
            System.out.println("l'utente non ha il ruolo valido per eseguire l'operazione");
            return res;
        } else {
            // Da controllare id e nome ruolo
            // Partendo da utente --> id_ruolo --> nome ruolo
            RoleEntity ruoloTrovato = roleDao.findByID(utenteTrovato.getIdRuolo());
//            RoleEntity ruoloTrovato = roleDao.findby(utenteTrovato.getNome());
            if (ruoloTrovato != null) {
                System.out.println("il ruolo esiste già");
                return false;
            } else {
                RoleEntity ruoloDaAggiungere = new RoleEntity();
                ruoloDaAggiungere.setNome(ruolo);
                roleDao.save(ruoloDaAggiungere);
                res = true;
                return res;
            }
        }
    }
    // Modifica il Ruolo (to do)

}