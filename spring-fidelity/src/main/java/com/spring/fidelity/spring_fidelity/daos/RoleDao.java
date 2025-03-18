package com.spring.fidelity.spring_fidelity.daos;

import com.spring.fidelity.spring_fidelity.entities.RoleEntity;
import com.spring.fidelity.spring_fidelity.entities.UserEntity;
import jakarta.persistence.JoinTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<RoleDao, Long> {

    @NativeQuery("select * from ruolo where nome = ?")
    public RoleEntity findby(String nome);

    @NativeQuery("select * from ruolo where id_ruolo = ?")
    public RoleEntity findByID(Long id_ruolo);

    @NativeQuery("insert into Role (nome) VALUES (?)")
    public RoleEntity save(RoleEntity nuovoRuolo);
}