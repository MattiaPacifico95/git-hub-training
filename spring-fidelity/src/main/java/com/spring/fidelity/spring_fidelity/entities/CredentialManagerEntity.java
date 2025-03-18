package com.spring.fidelity.spring_fidelity.entities;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "credential_manager")
public class CredentialManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_utente", nullable = false)
    private Long idUtente;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "data_creazione", nullable = false)
    private Timestamp dataCreazione;

    // Costruttori
    public CredentialManagerEntity() {
    }

    public CredentialManagerEntity(Long idUtente, String password, Timestamp dataCreazione) {
        this.idUtente = idUtente;
        this.password = password;
        this.dataCreazione = dataCreazione;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public String toString() {
        return "CredentialManagerEntity{" +
                "id=" + id +
                ", idUtente=" + idUtente +
                ", password='********'" + // Non mostrare la password completa nel log
                ", dataCreazione=" + dataCreazione +
                '}';
    }
}