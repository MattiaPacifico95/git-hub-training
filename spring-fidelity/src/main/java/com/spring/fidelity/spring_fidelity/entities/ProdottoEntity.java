package com.spring.fidelity.spring_fidelity.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "prodotto")
public class ProdottoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto")
    private long idProdotto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "immagine")
    private String immagine;

    @Column(name = "punti")
    private int punti;

    @Column(name = "data_creazione")
    private Timestamp dataCreazione;

    @Column(name = "flag_cancellato")
    private boolean flagCancellato;

    public ProdottoEntity() {
    }

    public long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public boolean isFlagCancellato() {
        return flagCancellato;
    }

    public void setFlagCancellato(boolean flagCancellato) {
        this.flagCancellato = flagCancellato;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Timestamp getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoEntity that = (ProdottoEntity) o;
        return idProdotto == that.idProdotto && punti == that.punti && flagCancellato == that.flagCancellato && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione) && Objects.equals(immagine, that.immagine) && Objects.equals(dataCreazione, that.dataCreazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdotto, nome, descrizione, immagine, punti, dataCreazione, flagCancellato);
    }

    @Override
    public String toString() {
        return "ProdottoEntity{" +
                "idProdotto=" + idProdotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", immagine='" + immagine + '\'' +
                ", punti=" + punti +
                ", dataCreazione=" + dataCreazione +
                ", flagCancellato=" + flagCancellato +
                '}';
    }
}
