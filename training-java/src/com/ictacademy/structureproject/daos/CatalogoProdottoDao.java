package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CatalogoProdottoEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdottoDao {

    DbConnection dbConnection = new DbConnection();

    // costruttore
    public CatalogoProdottoDao(){}

    public List<CatalogoProdottoEntity> findAll() throws SQLException {

        List<CatalogoProdottoEntity> listaCatalogoProdotto = new ArrayList<CatalogoProdottoEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CatalogoProdotto");

        while(rs.next()){
            CatalogoProdottoEntity catalogoProdotto = new CatalogoProdottoEntity();
            catalogoProdotto.setIdCatalogo(rs.getLong("id_catalogo"));
            catalogoProdotto.setIdProdotto(rs.getLong("id_prodotto"));
            listaCatalogoProdotto.add(catalogoProdotto);
        }
        conn.close();

        return listaCatalogoProdotto;
    }

    public List<CatalogoProdottoEntity> findByIdProdotto(long idProdotto) throws SQLException {

        List<CatalogoProdottoEntity> listaCatalogoProdotto = new ArrayList<CatalogoProdottoEntity>();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CatalogoProdotto where id_prodotto = ?");
        ps.setLong(1, idProdotto);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            CatalogoProdottoEntity catalogoProdotto = new CatalogoProdottoEntity();
            catalogoProdotto.setIdCatalogo(rs.getLong("id_catalogo"));
            catalogoProdotto.setIdProdotto(rs.getLong("id_prodotto"));
            listaCatalogoProdotto.add(catalogoProdotto);
        }
        conn.close();

        return listaCatalogoProdotto;
    }

    public List<CatalogoProdottoEntity> findByIdCatalogo(long idCatalogo) throws SQLException {

        List<CatalogoProdottoEntity> listaCatalogoProdotto = new ArrayList<CatalogoProdottoEntity>();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CatalogoProdotto where id_catalogo = ?");
        ps.setLong(1, idCatalogo);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            CatalogoProdottoEntity catalogoProdotto = new CatalogoProdottoEntity();
            catalogoProdotto.setIdCatalogo(rs.getLong("id_catalogo"));
            catalogoProdotto.setIdProdotto(rs.getLong("id_prodotto"));
            listaCatalogoProdotto.add(catalogoProdotto);
        }
        conn.close();

        return listaCatalogoProdotto;
    }

    public boolean createCatalogoProdotto(long idCatalogo, long idProdotto) throws SQLException {
        boolean created;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into CatalogoProdotto (id_catalogo, id_prodotto) values (?, ?)");
        ps.setLong(1, idCatalogo);
        ps.setLong(2, idProdotto);
        int rs = ps.executeUpdate();
        conn.close();

        if(rs>0) {
            created = true;
        } else {
            created = false;
        }
        return created;
    }

    public boolean deleteCatalogoProdotto(long idCatalogo, long idProdotto) throws SQLException {
        boolean deleted;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("delete from CatalogoProdotto where id_catalogo = ? and id_prodotto = ?");
        ps.setLong(1, idCatalogo);
        ps.setLong(2, idProdotto);
        int rs = ps.executeUpdate();
        conn.close();

        if(rs>0) {
            deleted = true;
        } else {
            deleted = false;
        }
        return deleted;

    }


}
