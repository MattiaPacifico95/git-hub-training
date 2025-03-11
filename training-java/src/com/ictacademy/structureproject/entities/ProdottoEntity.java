package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class ProdottoEntity {
    long id_prodotto;
    String nome;
    String descrizione;
    int punti;
    Timestamp data_creazione;
    Boolean flg_cancellato;

    // costruttore di default
    public ProdottoEntity() {
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public long getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(long id_prodotto) {
        this.id_prodotto = id_prodotto;
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
        return id_prodotto == that.id_prodotto && punti == that.punti && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione) && Objects.equals(data_creazione, that.data_creazione) && Objects.equals(flg_cancellato, that.flg_cancellato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prodotto, nome, descrizione, punti, data_creazione, flg_cancellato);
    }

    @Override
    public String toString() {
        return "ProdottoEntity{" +
                "id_prodotto=" + id_prodotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", punti=" + punti +
                ", data_creazione=" + data_creazione +
                ", flg_cancellato=" + flg_cancellato +
                '}';
    }
}
