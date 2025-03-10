package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class UserEntity {

    long idUtente;
    long idRuolo;
    String nome;
    String cognome;
    String email;
    Timestamp dataNascita;
    Timestamp dataCreazione;
    Timestamp dataUltimoAccesso;
    boolean flagCancellato;


    public UserEntity() {
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

    public Timestamp getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Timestamp dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Timestamp getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Timestamp getDataUltimoAccesso() {
        return dataUltimoAccesso;
    }

    public void setDataUltimoAccesso(Timestamp dataUltimoAccesso) {
        this.dataUltimoAccesso = dataUltimoAccesso;
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
        return idUtente == that.idUtente && idRuolo == that.idRuolo && flagCancellato == that.flagCancellato && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(email, that.email) && Objects.equals(dataNascita, that.dataNascita) && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(dataUltimoAccesso, that.dataUltimoAccesso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, email, idUtente, idRuolo, dataNascita, dataCreazione, dataUltimoAccesso, flagCancellato);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", idUtente=" + idUtente +
                ", idRuolo=" + idRuolo +
                ", dataNascita=" + dataNascita +
                ", dataCreazione=" + dataCreazione +
                ", dataUltimoAccesso=" + dataUltimoAccesso +
                ", flagCancellato=" + flagCancellato +
                '}';
    }

    public void setid(long idUser) {
    }
}