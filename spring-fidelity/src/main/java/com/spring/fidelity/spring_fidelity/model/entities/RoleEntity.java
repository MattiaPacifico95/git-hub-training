package com.spring.fidelity.spring_fidelity.model.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ruolo")

public class RoleEntity {

    //Dichiarazione Variabili, prende nelle tabelle correnti
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name = "id_ruolo")
    private Long IdRuolo;

    @Column (name = "nome")
    private String nome;

    // Costruttore
    public RoleEntity() {
    }

    //ID Get/Set
    public void setIdRuolo(Long IdRuolo) {
        this.IdRuolo = IdRuolo;
    }

    public Long getIdRuolo() {
        return IdRuolo;
    }

    // Nome Get/Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Equal e HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(IdRuolo, that.IdRuolo) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdRuolo, nome);
    }

    //ToString
    @Override
    public String toString() {
        return "RoleEntity{" +
                "IdRuolo=" + IdRuolo +
                ", nome='" + nome + '\'' +
                '}';
    }
}