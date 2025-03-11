package com.ictacademy.structureproject.services;

import com.ictacademy.structureproject.entities.UserEntity;

public class RoleServices {

    // Costruttore RoleServices
    public RoleServices() {
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
