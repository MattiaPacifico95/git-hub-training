package com.spring.fidelity.spring_fidelity.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity

@Table(name="catalogo")

public class CatalogoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private long idCatalogo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_creazione")
    private Timestamp dataCreazione;

    @Column(name = "fine_offerta")
    private Timestamp fineOfferta;

    @Column(name = "flag_cancellato")
    private boolean flagCancellato;

    public CatalogoEntity(){

    }

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

    public Timestamp getFineOfferta() {
        return fineOfferta;
    }

    public void setFineOfferta(Timestamp fineOfferta) {
        this.fineOfferta = fineOfferta;
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
        return idCatalogo == that.idCatalogo && flagCancellato == that.flagCancellato && Objects.equals(nome, that.nome) && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(fineOfferta, that.fineOfferta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatalogo, nome, dataCreazione, fineOfferta, flagCancellato);
    }

    @Override
    public String toString() {
        return "CatalogoEntity{" +
                "idCatalogo=" + idCatalogo +
                ", nome='" + nome + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", fineOfferta=" + fineOfferta +
                ", flagCancellato=" + flagCancellato +
                '}';
    }
}