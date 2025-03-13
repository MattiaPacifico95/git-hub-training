package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.daos.RoleDao;
import com.ictacademy.structureproject.daos.UserDao;
import com.ictacademy.structureproject.entities.RoleEntity;
import com.ictacademy.structureproject.entities.UserEntity;

import java.sql.SQLException;

public class RoleServices {

    RoleDao roleDao = new RoleDao();
    UserDao userDao = new UserDao();

    // Costruttore RoleServices
    public RoleServices() {
    }

    //creazione del nuovo ruolo
    public boolean addRole(Long idUser, String ruolo) throws SQLException {

        boolean res = false;

        UserEntity user = new UserEntity();
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




    // Modifica il Ruolo Utente, prende in ingresso UserEntity come oggetto
    public boolean ModificaRoleUser (UserEntity user) {
        // Se (prende IdRuolo e fa comparazione a 1) allora ritorna su False
        if (user.getIdRuolo() == 1) {
            return false;
        // se no Set IdRuolo a 2 e torna su True
        } else {
            user.setIdRuolo(2);
            return true;
        }
    }
}
