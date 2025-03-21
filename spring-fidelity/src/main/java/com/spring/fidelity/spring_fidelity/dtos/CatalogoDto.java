package com.spring.fidelity.spring_fidelity.dtos;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
public class CatalogoDto {

    private long catID;

    private String trueName;

    private Timestamp endOffer;

    private boolean flagCancelled;


    public long getCatID() {
        return catID;
    }

    public void setCatID(long catID) {
        this.catID = catID;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Timestamp getEndOffer() {
        return endOffer;
    }

    public void setEndOffer(Timestamp endOffer) {
        this.endOffer = endOffer;
    }

    public boolean isFlagCancelled() {
        return flagCancelled;
    }

    public void setFlagCancelled(boolean flagCancelled) {
        this.flagCancelled = flagCancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CatalogoDto that = (CatalogoDto) o;
        return catID == that.catID && flagCancelled == that.flagCancelled && Objects.equals(trueName, that.trueName) && Objects.equals(endOffer, that.endOffer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catID, trueName, endOffer, flagCancelled);
    }

    @Override
    public String toString() {
        return "CatalogoDto{" +
                "catID=" + catID +
                ", trueName='" + trueName + '\'' +
                ", endOffer=" + endOffer +
                ", flagCancelled=" + flagCancelled +
                '}';
    }
}


