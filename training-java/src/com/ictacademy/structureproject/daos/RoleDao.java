package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.RoleEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    DbConnection dbConnection = new DbConnection();

    // Costruttore RoleDao
    public RoleDao() {}

    // select * from Role where idRuolo = ?
    public RoleEntity findById(long idRuolo) throws SQLException {

        RoleEntity role = new RoleEntity();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from Role where id_role = ?");
        ps.setLong(1, idRuolo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            role.setidRuolo(rs.getLong("id_role"));
            role.setName(rs.getString("nome"));
        }
        conn.close();

        return role;
    }

    //select * from Role
    public List<RoleEntity> findAll() throws SQLException {
        List<RoleEntity> list = new ArrayList<RoleEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Role");

        while (rs.next()) {
            RoleEntity role = new RoleEntity();
            role.getIdRuolo(rs.getLong("id_Role"));
            role.getName(rs.getString("nome"));
            list.add(role);
        }
        conn.close();
        return list;
    }

    // insert into Role values (?, ?)
    public boolean RoleEntityCreate(long idRuolo, String nome) throws SQLException {

        boolean risultatoCreateRole;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into Role (id_role, nome) VALUES (?, ?");
        ps.setLong(1, idRuolo);
        ps.setString(2, nome);

        int risultato = ps.executeUpdate();
        if (risultato > 0) {
            risultatoCreateRole = true;
        } else {
            risultatoCreateRole = false;
        }
        conn.close();
        return risultatoCreateRole;
    }

    // Update Role set (nome) = ? where idRuolo = ?
    public boolean RoleUpdate(String nome, long idRuolo) throws SQLException {
        boolean risultatoUpdate;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("Update Role set (nome) = ? where id_role = (?");
        ps.setString(1, nome);
        ps.setLong(2, idRuolo);
        int risultato = ps.executeUpdate();

        if (risultato > 0) {
            risultatoUpdate = true;
        } else {
            risultatoUpdate = false;
        }

        conn.close();
        return risultatoUpdate;
    }

    //  Delete from Role where id_role = ?
    public boolean deleteRole(long idRuolo) throws SQLException {
        boolean risultatoDelete;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("Delete from Role where id_role = (?");
        ps.setLong(1, idRuolo);

        int risultato = ps.executeUpdate();
        if (risultato > 0) {
            risultatoDelete = true;
        } else {
            risultatoDelete = false;
        }

        conn.close();
        return risultatoDelete;
    }
}
