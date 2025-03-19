package com.spring.fidelity.spring_fidelity.entities;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "catalogo_prodotto")
public class CatalogoProdottoEntity {

    //@EmbeddedId

    @Column(name = "id_catalogo")
    private Long idCatalogo;

    @Column(name = "id_prodotto")
    private Long idProdotto;

    @Column(name = "data_aggiunta")
    private Timestamp dataAggiunta;

    @ManyToOne
    @JoinColumn(
            name = "id_catalogo",
            referencedColumnName = "id_catalogo"
    )
    private CatalogoEntity catalogo;

    @ManyToOne
    @JoinColumn(
            name = "id_prodotto",
            referencedColumnName = "id_prodotto"
    )
    private ProdottoEntity prodotto;


    public CatalogoProdottoEntity() {
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public Timestamp getDataAggiunta() {
        return dataAggiunta;
    }

    public void setDataAggiunta(Timestamp dataAggiunta) {
        this.dataAggiunta = dataAggiunta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CatalogoProdottoEntity that = (CatalogoProdottoEntity) o;
        return Objects.equals(idCatalogo, that.idCatalogo) && Objects.equals(idProdotto, that.idProdotto) && Objects.equals(dataAggiunta, that.dataAggiunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatalogo, idProdotto, dataAggiunta);
    }

    @Override
    public String toString() {
        return "CatalogoProdottoEntity{" +
                "idCatalogo=" + idCatalogo +
                ", idProdotto=" + idProdotto +
                ", dataAggiunta=" + dataAggiunta +
                '}';
    }
}
