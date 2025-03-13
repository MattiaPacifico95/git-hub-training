package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class CatalogoEntity {
    long idCatalogo;
    String nome;
    Timestamp dataCreazione;
    boolean flagCancellato;
    Timestamp fineOfferta;

    public CatalogoEntity(){}

    public long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public boolean isFlagCancellato() {
        return flagCancellato;
    }

    public void setFlagCancellato(boolean flagCancellato) {
        this.flagCancellato = flagCancellato;
    }


    public Timestamp getFineOfferta() {
        return fineOfferta;
    }

    public void setFineOfferta(Timestamp fineOfferta) {
        this.fineOfferta = fineOfferta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatalogo, nome, dataCreazione, flagCancellato, fineOfferta);

    }

    @Override
    public String toString() {
        return "CatalogoEntity{" +
                "idCatalogo=" + idCatalogo +
                ", nome='" + nome + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", flagCancellato=" + flagCancellato +
                ", fineOfferta=" + fineOfferta +
                '}';
    }
}
