package com.spring.fidelity.spring_fidelity.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "credential_manager")
public class CredentialManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cm")
    private long idCm;

    @Column(name= "id_utente")
    private long idUtente;

    @Column(name = "psw")
    private String psw;

    @Column(name = "data_creazione")
    private LocalDateTime dataCreazione;

    @Column(name = "data_rinnovo")
    private LocalDateTime dataRinnovo;

    @ManyToOne
    @JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
    private UserEntity user;

    public CredentialManagerEntity() {
    }

    public long getIdCm() {
        return idCm;
    }

    public void setIdCm(long idCm) {
        this.idCm = idCm;
    }

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public LocalDateTime getDataRinnovo() {
        return dataRinnovo;
    }

    public void setDataRinnovo(LocalDateTime dataRinnovo) {
        this.dataRinnovo = dataRinnovo;
    }

    @Override
    public String toString() {
        return "CredentialManagerEntity{" +
                "idCm=" + idCm +
                ", user=" + user +
                ", psw='" + psw + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", dataRinnovo=" + dataRinnovo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialManagerEntity that = (CredentialManagerEntity) o;
        return idCm == that.idCm &&
                Objects.equals(user, that.user) &&
                Objects.equals(psw, that.psw) &&
                Objects.equals(dataCreazione, that.dataCreazione) &&
                Objects.equals(dataRinnovo, that.dataRinnovo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCm, user, psw, dataCreazione, dataRinnovo);
    }
}