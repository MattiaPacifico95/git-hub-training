package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class CatalogoEntity {
    long idCatalogo;
    String nome;
    Timestamp dataCreazione;
    boolean flagCancellato;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CatalogoEntity that = (CatalogoEntity) o;
        return idCatalogo == that.idCatalogo && flagCancellato == that.flagCancellato && Objects.equals(nome, that.nome) && Objects.equals(dataCreazione, that.dataCreazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatalogo, nome, dataCreazione, flagCancellato);
    }

    @Override
    public String toString() {
        return "CatalogoEntity{" +
                "idCatalogo=" + idCatalogo +
                ", nome='" + nome + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", flagCancellato=" + flagCancellato +
                '}';
    }
}
