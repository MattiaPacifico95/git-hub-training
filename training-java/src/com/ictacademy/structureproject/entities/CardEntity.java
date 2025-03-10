package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class CardEntity {
    long idTessera;
    long idUtente;
    int saldoPunti;
    Timestamp dattaAttivazione;
     Timestamp dataScadenza;
    boolean flagCancellato;

     public CardEntity(){} // questo è il costruttore
// get e set
    public long getIdTessera() {
        return idTessera; }

    public void setIdTessera(long idTessera) {
        this.idTessera = idTessera;
    }

    public int getSaldoPunti() {
        return saldoPunti;
    }

    public void setSaldoPunti(int saldoPunti) {
        this.saldoPunti = saldoPunti;
    }

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
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

    public Timestamp getDattaAttivazione() {
        return dattaAttivazione;
    }

    public void setDattaAttivazione(Timestamp dattaAttivazione) {
        this.dattaAttivazione = dattaAttivazione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity userCard = (CardEntity) o;
        return idTessera == userCard.idTessera && idUtente == userCard.idUtente && saldoPunti == userCard.saldoPunti && flagCancellato == userCard.flagCancellato && Objects.equals(dattaAttivazione, userCard.dattaAttivazione) && Objects.equals(dataScadenza, userCard.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTessera, idUtente, saldoPunti, dattaAttivazione, dataScadenza, flagCancellato);
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "idTessera=" + idTessera +
                ", idUtente=" + idUtente +
                ", saldoPunti=" + saldoPunti +
                ", dattaAttivazione=" + dattaAttivazione +
                ", dataScadenza=" + dataScadenza +
                ", flagCancellato=" + flagCancellato +
                '}';
    }
}

