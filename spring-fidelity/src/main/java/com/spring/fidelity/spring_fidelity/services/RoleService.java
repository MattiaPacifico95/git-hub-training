package com.spring.fidelity.spring_fidelity.services;

import com.spring.fidelity.spring_fidelity.daos.RoleDao;
import com.spring.fidelity.spring_fidelity.daos.UserDao;
import com.spring.fidelity.spring_fidelity.entities.RoleEntity;
import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RoleService {

    // Recupero Id utente
    RoleDao roleDao;
    UserDao userDao;

    //Costruttore
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    // Creazione del nuovo ruolo
    public boolean addRole(Long idUser, String ruolo) throws SQLException {

        boolean res = false;

        UserEntity utenteTrovato = userDao.findBy(idUser);
        // Controlla se l'utente è admin o un utente normale
        if(utenteTrovato.getIdRuolo() != 3) {
            System.out.println("l'utente non ha il ruolo valido per eseguire l'operazione");
            return res;
        } else {
            // Da controllare id e nome ruolo
            // Partendo da utente --> id_ruolo --> nome ruolo
            RoleEntity ruoloTrovato = roleDao.findByID(utenteTrovato.getIdRuolo()); // Trova ID
            // Se esiste allora ritorna su False
            if (ruoloTrovato != null) {
                System.out.println("il ruolo esiste già");
                return false;
            // Se no viene aggiunto il ruolo
            } else {
                RoleEntity ruoloDaAggiungere = new RoleEntity();
                ruoloDaAggiungere.setNome(ruolo);
                roleDao.save(ruoloDaAggiungere);
                res = true;
                return res;
            }
        }
    }
    // Modifica il nome del ruolo
//    public String updateNameRole(String nuovoNomeRuolo) {
//
//        RoleEntity roleEntity = roleDao.findBy(RoleDao);
//    }
}