package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;


public class ProdottoEntity {
    long id_utente;
    String nome;
    String descrizione;
    Timestamp data_creazione;
    Boolean flg_cancellato;

    // costruttore di default
    public ProdottoEntity() {
    }


    public long getId_utente() {
        return id_utente;
    }

    public void setId_utente(long id_utente) {
        this.id_utente = id_utente;
    }

    public Boolean getFlg_cancellato() {
        return flg_cancellato;
    }

    public void setFlg_cancellato(Boolean flg_cancellato) {
        this.flg_cancellato = flg_cancellato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Timestamp getData_creazione() {
        return data_creazione;
    }

    public void setData_creazione(Timestamp data_creazione) {
        this.data_creazione = data_creazione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoEntity that = (ProdottoEntity) o;
        return id_utente == that.id_utente && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione) && Objects.equals(data_creazione, that.data_creazione) && Objects.equals(flg_cancellato, that.flg_cancellato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_utente, nome, descrizione, data_creazione, flg_cancellato);
    }

    @Override
    public String toString() {
        return "ProdottoEntity{" +
                "id_utente=" + id_utente +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", data_creazione=" + data_creazione +
                ", flg_cancellato=" + flg_cancellato +
                '}';
    }
}