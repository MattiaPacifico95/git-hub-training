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

    // metodo per ottenere ogni relazione cataogo - prodotto
    public List<CatalogoProdottoEntity> findAll() throws SQLException {
        // creare lista per output
        List<CatalogoProdottoEntity> listaCatalogoProdotto = new ArrayList<CatalogoProdottoEntity>();

        Connection conn = dbConnection.creaConnessione(); // step 1: aprire connessione
        Statement stmt = conn.createStatement(); // step 2: creazione statement query
        ResultSet rs = stmt.executeQuery("select * from CatalogoProdotto"); // step 3: esecuzione query

        while(rs.next()){ // step 4: ciclare lista output e creo oggetti in lista

            CatalogoProdottoEntity catalogoProdotto = new CatalogoProdottoEntity();
            catalogoProdotto.setIdCatalogo(rs.getLong("id_catalogo"));
            catalogoProdotto.setIdProdotto(rs.getLong("id_prodotto"));
            listaCatalogoProdotto.add(catalogoProdotto);
        }

        conn.close(); // step 5: chiudere connessione

        return listaCatalogoProdotto; // ritornare lista

    }

    public List<CatalogoProdottoEntity> findByIdProdotto(long idProdotto) throws SQLException {

        List<CatalogoProdottoEntity> listaCatalogoProdotto = new ArrayList<CatalogoProdottoEntity>();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CatalogoProdotto where id_prodotto = ?");

        // preparedstatement, utilizzare quando elementi della query sono variabili

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


    public boolean isProdottoInCatalogo(long idProdotto, long idCatalogo) throws SQLException {
        boolean esiste;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from CatalogoProdotto where id_prodotto = ? and id_catalogo = ?");
        ps.setLong(1, idProdotto);
        ps.setLong(2, idCatalogo);
        ResultSet rs = ps.executeQuery();
        CatalogoProdottoEntity catalogoProdotto = new CatalogoProdottoEntity();
        while(rs.next()){
            catalogoProdotto.setIdCatalogo(rs.getLong("id_catalogo"));
            catalogoProdotto.setIdProdotto(rs.getLong("id_prodotto"));
        }
        conn.close();

        return esiste = catalogoProdotto != null ? true : false;
    }


    public boolean createCatalogoProdotto(long idCatalogo, long idProdotto) throws SQLException {
        boolean created;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into CatalogoProdotto (id_catalogo, id_prodotto) values (?, ?)");
        ps.setLong(1, idCatalogo);
        ps.setLong(2, idProdotto);

        int rs = ps.executeUpdate(); // query che scrivono sul DB si eseguono come update

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
