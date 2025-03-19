package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.ProdottoEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDao {
    DbConnection dbConnection = new DbConnection();

    public ProdottoEntity findById(long id) throws SQLException {

        ProdottoEntity prodotto = new ProdottoEntity();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from Prodotto where id_Prodotto = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            prodotto.setId_prodotto(rs.getLong("id_prodotto"));
            prodotto.setNome(rs.getString("nome"));
            prodotto.setDescrizione(rs.getString("descrizione"));
            prodotto.setPunti(rs.getInt("punti"));
            prodotto.setData_creazione(rs.getTimestamp("data_creazione"));
            prodotto.setFlg_cancellato(rs.getBoolean("flg_cancellato"));
        }

        conn.close();

        return prodotto;
    }

    public List<ProdottoEntity> findAll() throws SQLException {

        List<ProdottoEntity> listaProdotti = new ArrayList<ProdottoEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Prodotto");

        while (rs.next()) {
            ProdottoEntity prodotto = new ProdottoEntity();
            prodotto.setId_prodotto(rs.getLong("id_utente"));
            prodotto.setNome(rs.getString("nome"));
            prodotto.setDescrizione(rs.getString("descrizione"));
            prodotto.setPunti(rs.getInt("punti"));
            prodotto.setData_creazione(rs.getTimestamp("data_creazione"));
            listaProdotti.add(prodotto);
        }

        return listaProdotti;
    }

    public boolean createProdotto(long id_prodotto, String nome, String descrizione, int punti, Timestamp dataCreazione, boolean flg_cancellato) throws SQLException {

        boolean insertAvvenuta;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("INSERT into Prodotto (id_prodotto, nome, descrizione, punti, dataCreazione, flg_cancellato) VALUES (?,?,?,?,?,?)");
        ps.setLong(1, id_prodotto);
        ps.setString(2, nome);
        ps.setString(3, descrizione);
        ps.setInt(4, punti);
        ps.setTimestamp(5, dataCreazione);
        ps.setBoolean(6, flg_cancellato);

        int risultato = ps.executeUpdate();

        if (risultato > 0) {
            insertAvvenuta = true;
        } else {
            insertAvvenuta = false;
        }

        return insertAvvenuta;
    }




    public boolean updateProdotto(String nome, String descrizione, int punti, Timestamp dataCreazione) throws SQLException {

        boolean insertAvvenuta;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("UPDATE into Prodotto (nome, descrizione, punti, dataCreazione) VALUES (?,?,?,?)");
        ps.setString(1, nome);
        ps.setString(2, descrizione);
        ps.setInt(3, punti);
        ps.setTimestamp(4, dataCreazione);

        int risultato = ps.executeUpdate();

        if (risultato > 0) {
            insertAvvenuta = true;
        } else {
            insertAvvenuta = false;
        }

        return insertAvvenuta;
    }



    public boolean logicDelete(long id_utente, boolean flg_cancellato) throws SQLException {

        boolean insertAvvenuta;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("DELETE into Prodotto (id_utente, flg_cancellato) VALUES (?, ?)");
        ps.setBoolean(1, flg_cancellato);

        int risultato = ps.executeUpdate();

        if (risultato > 0) {
            insertAvvenuta = true;
        } else {
            insertAvvenuta = false;
        }

        return insertAvvenuta;


    }

}
