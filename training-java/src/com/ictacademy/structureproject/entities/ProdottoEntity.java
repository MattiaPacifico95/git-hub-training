package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class ProdottoEntity {
    long idProdotto;
    String nome;
    String descrizione;
    int punti;
    Timestamp dataCreazione;
    Boolean flgCancellato;

    // costruttore di default
    public ProdottoEntity() {
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public Boolean getflgCancellato() {
        return flgCancellato;
    }

    public void setflgCancellato(Boolean flgCancellato) {
        this.flgCancellato = flgCancellato;
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

    public Timestamp getdataCreazione() {
        return dataCreazione;
    }

    public void setdataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoEntity that = (ProdottoEntity) o;
        return idProdotto == that.idProdotto && punti == that.punti && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione) && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(flgCancellato, that.flgCancellato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdotto, nome, descrizione, punti, dataCreazione, flgCancellato);
    }

    @Override
    public String toString() {
        return "ProdottoEntity{" +
                "idProdotto=" + idProdotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", punti=" + punti +
                ", data_creazione=" + dataCreazione +
                ", flg_cancellato=" + flgCancellato +
                '}';
    }
}
