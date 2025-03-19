package com.spring.fidelity.spring_fidelity.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Tessera")
public class TesseraEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name =  "id_tessera")
    private long idTessera;

    @Column(name = "id_utente")
    private long idUtente;

    @Column(name = "data_attivazione")
    private Timestamp dataAttivazione;

    @Column(name = "saldo_punti")
    private int saldoPunti;

    @Column(name = "data_scadenza")
    private Timestamp dataScadenza;

    @Column(name = "flag_cancellato")
    private boolean flagCancellato;

    @ManyToOne
    @JoinColumn(
            name = "id_utente",
            referencedColumnName = "id_utente"
    )
    private UserEntity utente;


    public Timestamp getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(Timestamp dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public long getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(long idTessera) {
        this.idTessera = idTessera;
    }

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    public int getSaldoPunti() {
        return saldoPunti;
    }

    public void setSaldoPunti(int saldoPunti) {
        this.saldoPunti = saldoPunti;
    }

    public boolean isFlagCancellato() {
        return flagCancellato;
    }

    public void setFlagCancellato(boolean flagCancellato) {
        this.flagCancellato = flagCancellato;
    }

    public Timestamp getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Timestamp dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TesseraEntity that = (TesseraEntity) o;
        return idUtente == that.idUtente && idTessera == that.idTessera && saldoPunti == that.saldoPunti && flagCancellato == that.flagCancellato && Objects.equals(dataAttivazione, that.dataAttivazione) && Objects.equals(dataScadenza, that.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente, idTessera, dataAttivazione, saldoPunti, dataScadenza, flagCancellato);
    }

    @Override
    public String toString() {
        return "TesseraEntity{" +
                "idTessera=" + idTessera +
                ", idUtente=" + idUtente +
                ", dataAttivazione=" + dataAttivazione +
                ", saldoPunti=" + saldoPunti +
                ", dataScadenza=" + dataScadenza +
                ", flagCancellato=" + flagCancellato +
                '}';
    }
}
