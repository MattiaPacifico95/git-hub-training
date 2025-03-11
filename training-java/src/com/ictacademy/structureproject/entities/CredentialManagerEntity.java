package com.ictacademy.structureproject.entities;

import java.util.Date;
import java.sql.Timestamp; // Import corretto per Timestamp, se necessario
import java.util.Objects;

public class CredentialManagerEntity {
    private long idCm;           // id_cm
    private long idUtente;       // id_utente
    private String psw;          // psw
    private Date dataCreazione;  // data_creazione
    private Date dataRinnovo;    // data_rinnovo

    // Costruttore vuoto
    public CredentialManagerEntity() {
    }

    public CredentialManagerEntity(long idCredentialManager, String password, Timestamp dataCreazione, long idUtente, Timestamp dataRinnovo) {
    }


    // Getter e Setter per idCm
    public long getIdCm() {
        return idCm;
    }

    public void setIdCm(long idCm) {
        this.idCm = idCm;
    }

    // Getter e Setter per idUtente
    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    // Getter e Setter per psw
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    // Getter e Setter per dataCreazione
    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    // Getter e Setter per dataRinnovo
    public Date getDataRinnovo() {
        return dataRinnovo;
    }

    public void setDataRinnovo(Date dataRinnovo) {
        this.dataRinnovo = dataRinnovo;
    }

    // Metodo toString per una rappresentazione leggibile
    @Override
    public String toString() {
        return "CredentialManagerEntity{" +
                "idCm=" + idCm +
                ", idUtente=" + idUtente +
                ", psw='" + psw + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", dataRinnovo=" + dataRinnovo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CredentialManagerEntity that = (CredentialManagerEntity) o;
        return idCm == that.idCm && idUtente == that.idUtente && Objects.equals(psw, that.psw) && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(dataRinnovo, that.dataRinnovo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCm, idUtente, psw, dataCreazione, dataRinnovo);
    }
}