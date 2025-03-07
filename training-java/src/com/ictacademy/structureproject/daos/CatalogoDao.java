package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.CatalogoEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDao {
    DbConnection dbConnection = new DbConnection();

    public CatalogoEntity findById(long id) throws SQLException {

        CatalogoEntity catalogo = new CatalogoEntity();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from Catalogo where id_Catalogo = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            catalogo.setIdCatalogo(rs.getLong("id_Catalogo"));
            catalogo.setNome(rs.getString("nome"));
            catalogo.setDataCreazione(rs.getTimestamp("data_di_Creazione"));
            catalogo.setFlagCancellato(rs.getBoolean("flagCancellato"));
        }

        conn.close();

        return catalogo;
    }


    public List<CatalogoEntity> findAll() throws SQLException {

        List<CatalogoEntity> listaCatalogo = new ArrayList<CatalogoEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Catalogo");

        while (rs.next()) {
            CatalogoEntity catalogo = new CatalogoEntity();
            catalogo.setIdCatalogo(rs.getLong("id_Catalogo"));
            catalogo.setNome(rs.getString("nome"));
            catalogo.setDataCreazione(rs.getTimestamp("data_di_Creazione"));
            catalogo.setFlagCancellato(rs.getBoolean("flagcancellato"));
            listaCatalogo.add(catalogo);
        }

        return listaCatalogo;
    }

    public boolean createCatalogo(String nome, Timestamp dataCreazione, boolean flagCancellato) throws SQLException {
        boolean catalogato;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into Catalogo (Nome, dataCreazione, flagCancellato) values (?, ?, ?)");;
        ps.setString(1, nome);
        ps.setTimestamp(2, dataCreazione);
        ps.setBoolean(3, flagCancellato);
        int rs = ps.executeUpdate();
        conn.close();
        if (rs > 0) {
            catalogato = true;
        }else{
            catalogato = false;
        }
        return catalogato;
    }

    // update USER set (nome,....) where ID_USER = ?
    public boolean updateCatalogo (String nome, long idCatalogo) throws SQLException {
        boolean catAggiornato;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("Update Catalogo Set nome = ? Where id_Catalogo = ?");;
        ps.setString(1, nome);
        ps.setLong(2, idCatalogo);
        int rs = ps.executeUpdate();
        conn.close();
        if (rs > 0) {
            catAggiornato = true;
        }else{
            catAggiornato = false;
        }
        return catAggiornato;
    }
    // update User set (flag_cancellato = 1) Where id_user = ?
    public boolean logicDelete(long idCatalogo) throws SQLException {
        boolean catCancellato;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("Update Catalogo set (flagCancellato = 1) Where id_Catalogo = ? ");
        ps.setLong(1, idCatalogo);
        int rs = ps.executeUpdate();
        conn.close();
        if (rs > 0) {
            catCancellato = true;
        }else{
            catCancellato = false;
        }
        return catCancellato;

    }

    public boolean catalogoRimosso (long idCatalogo) throws SQLException {
        boolean catRimosso;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("Delete From Catalogo where id_Catalogo = ? ");
        ps.setLong(1, idCatalogo);
        int rs = ps.executeUpdate();
        conn.close();
        if (rs > 0) {
            catRimosso = true;
        }else{
            catRimosso = false;
        }
        return catRimosso;

    }



}
