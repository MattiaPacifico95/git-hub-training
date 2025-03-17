package com.spring.fidelity.spring_fidelity.entities;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "utente")
public class UserEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente")
    private long idUtente;

    @Column(name = "id_ruolo")
    private long idRuolo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascita")
    private Timestamp dataNascita;

    @Column(name = "flag_cancellato")
    private boolean flagCancellato;

    @ManyToOne
    @JoinColumn(
            name = "id_ruolo",
            referencedColumnName = "id_ruolo"
    )
    private RoleEntity ruoli;

    public UserEntity() {
    }

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    public long getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(long idRuolo) {
        this.idRuolo = idRuolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Timestamp dataNascita) {
        this.dataNascita = dataNascita;
    }

    public boolean isFlagCancellato() {
        return flagCancellato;
    }

    public void setFlagCancellato(boolean flagCancellato) {
        this.flagCancellato = flagCancellato;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUtente == that.idUtente && idRuolo == that.idRuolo && flagCancellato == that.flagCancellato && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(email, that.email) && Objects.equals(dataNascita, that.dataNascita) && Objects.equals(ruoli, that.ruoli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente, idRuolo, nome, cognome, email, dataNascita, flagCancellato, ruoli);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUtente=" + idUtente +
                ", idRuolo=" + idRuolo +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", flagCancellato=" + flagCancellato +
                ", ruoli=" + ruoli +
                '}';
    }
}
