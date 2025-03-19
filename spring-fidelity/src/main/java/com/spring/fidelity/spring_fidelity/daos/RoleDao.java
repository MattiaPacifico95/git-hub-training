package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<RoleDao, Long> {

    // Trova nome del ruolo
    @NativeQuery("select * from ruolo where nome = ?")
    public RoleEntity findby(String nome);

    // Trova Id del ruolo
    @NativeQuery("select * from ruolo where id_ruolo = ?")
    public RoleEntity findByID(Long id_ruolo);

    // Per creare nuovo ruolo
    @NativeQuery("insert into Role (nome) VALUES ?")
    public RoleEntity save(RoleEntity nuovoRuolo);

    // Aggiorna il Nome del ruolo nella tabella
    @NativeQuery("update Role set (nome) = ? where id_role = ?")
    public RoleEntity update(String nuovoNomeRuolo, Long id_ruolo);
}