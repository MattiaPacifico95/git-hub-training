package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CardEntity;
import com.ictacademy.structureproject.entities.UserEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.smartcardio.Card;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDao {
    DbConnection dbConnection = new DbConnection();

    public CardDao() {}
    public CardEntity findById(long id) throws SQLException {
        CardEntity card = new CardEntity();

        Connection conn = dbConnection.creaConnessione();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE idCard = ? ");
        ps.setLong (1,id);
       ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            card.setIdTessera(rs.getLong("id_tessera"));
            card.setIdUtente(rs.getLong("id_utente"));
            card.setDataScadenza(rs.getTimestamp("data_attivazione"));
            card.setSaldoPunti(rs.getInt("saldo_punti"));
            card.setDattaAttivazione(rs.getTimestamp("data_attivazione"));
            card.setFlagCancellato(rs.getBoolean("Flag_cancellato"));
        }
        conn.close();
        return card;

    }
    public List<CardEntity> findAll() throws SQLException {

        List<CardEntity> listaCards = new ArrayList<CardEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CARDS");

        while (rs.next()) {
            CardEntity card = new CardEntity();
            card.setIdTessera(rs.getLong("id_tessera"));
            card.setIdUtente(rs.getLong("id_utente"));
            card.setDataScadenza(rs.getTimestamp("data_attivazione"));
            card.setSaldoPunti(rs.getInt("saldo_punti"));
            card.setDattaAttivazione(rs.getTimestamp("data_attivazione"));
            card.setFlagCancellato(rs.getBoolean("Flag_cancellato"));
        }
        conn.close();
        return listaCards;
    }

    // insert into User values (idUtente, ...)
    public boolean createCard(long id_tessera, long id_utente, int saldo_punti, Timestamp data_attivazione, Timestamp data_scadenza, boolean flag_cancellato) throws SQLException {
        boolean created;
        Connection conn = dbConnection.creaConnessione();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO CARDS(id_tessera, id_utente, saldo_punti, data_attivazione, data_scadenza, flag_cancellazione) values (?, ?, ?, ?, ?, ?)");
        ps.setLong(1, id_tessera);
        ps.setLong(2, id_utente);
        ps.setInt(3, saldo_punti);
        ps.setTimestamp(4, data_attivazione);
        ps.setTimestamp(5, data_scadenza);
        ps.setBoolean(6, flag_cancellato);
        int rs = ps.executeUpdate();
        conn.close();
        if (rs > 0) {
            created = true;
        } else {
            created = false;
        }
        return created;
    }
}
