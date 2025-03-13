package com.ictacademy.structureproject.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class CatalogoProdottoEntity {
    // proprietà
    private Long idCatalogo;
    private Long idProdotto;
    private Timestamp dataAggiunta;

    // costruttore
    public CatalogoProdottoEntity(){
    }

    // get/set proprietà
    public Long getIdCatalogo() {
        return idCatalogo;
    }
    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }
    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public Timestamp getDataAggiunta() {
        return dataAggiunta;
    }
    public void setDataAggiunta(Timestamp dataAggiunta) {
        this.dataAggiunta = dataAggiunta;
    }

    // override equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CatalogoProdottoEntity that = (CatalogoProdottoEntity) o;
        return Objects.equals(idCatalogo, that.idCatalogo) && Objects.equals(idProdotto, that.idProdotto) && Objects.equals(dataAggiunta, that.dataAggiunta);
    }

    // override to string
    @Override
    public String toString() {
        return "CatalogoProdottoEntity{" +
                "idCatalogo=" + idCatalogo +
                ", idProdotto=" + idProdotto +
                ", dataAggiunta=" + dataAggiunta +
                '}';
    }

    // override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idCatalogo, idProdotto, dataAggiunta);
    }
}
