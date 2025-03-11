package com.ictacademy.structureproject.daos;

import com.ictacademy.structureproject.entities.UserEntity;
import com.ictacademy.structureproject.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /* svolgere le operazioni di CRUD quindi fare
    le mie query select, insert, update, delete
     */

    DbConnection dbConnection = new DbConnection();


    /*
    ResultSet result = statement.executeQuery(sql);

    while(result.next()) {

        String name = result.getString("name");
        long   age  = result.getLong  ("age");

    }

      String sql = "select * from people";
    String sql2 = "select * from User where id_user = ? ";

    Statement st = conn.createStatement(sql);

    PreparedStatement pstmt = conn.prepareStatement(sql2);
      pstmt.setInt(1, 30);
      pstmt.setString(2, "Mario");


     */



    // select * from USER where id_User = ?
    public UserEntity findById(long id) throws SQLException {

        UserEntity user = new UserEntity();

       Connection conn = dbConnection.creaConnessione();
       PreparedStatement ps = conn.prepareStatement("select * from USER where idUtente = ?");
       ps.setLong(1, id);
       ResultSet rs = ps.executeQuery();

       while (rs.next()) {
           user.setIdUtente(rs.getLong("id_User"));
           user.setNome(rs.getString("nome"));
           user.setEmail(rs.getString("email"));
       }

       conn.close();

       return user;
    }

    //select * from USER where email = ?
    public UserEntity findByEmail(String email) throws SQLException {

        UserEntity user = new UserEntity();

        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("select * from USER where email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            user.setIdUtente(rs.getLong("id_User"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setCognome(rs.getString("cognome"));
            user.setDataNascita(rs.getTimestamp("dataNascita"));
            user.setIdRuolo(rs.getLong("idRuolo"));
        }
        conn.close();
        return user;
    }

    //select * from USER
    public List<UserEntity> findAll() throws SQLException {

        List<UserEntity> listaUtenti = new ArrayList<UserEntity>();

        Connection conn = dbConnection.creaConnessione();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from USER");

        while (rs.next()) {
            UserEntity user = new UserEntity();
            user.setIdUtente(rs.getLong("id_User"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            listaUtenti.add(user);
        }
        conn.close();

        return listaUtenti;
    }

    // insert into User values (idUtente, ...)

    public boolean createUser(String nome, String cognome, String email, Timestamp dataNascita) throws SQLException {
        boolean created;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("insert into User (nome, cognome, email, data_di_nascita) values (?, ?, ?, ?)");
        ps.setString(1, nome);
        ps.setString(2, cognome);
        ps.setString(3, email);
        ps.setTimestamp(4, dataNascita);
        int rs = ps.executeUpdate();
        conn.close();

        if (rs > 0) {
            created = true;
        }else{
            created = false;
        }
        //created = rs > 0 ? true : false; // operatore ternario

        return created;
    }

    // update USER set (nome,....) where ID_USER = ?
    public boolean updateUser(String nome,String cognome,String email,Timestamp data,long id_utente) throws SQLException {
        boolean b;
        Connection conn = dbConnection.creaConnessione();
        ///////UPDATE Person SET given_names = 'Stefano' WHERE ID = 4;
        String sql ="update USER set nome = ?, cognome = ?, email = ?, data_di_nascita= ? where id_utente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, cognome);
        ps.setString(3, email);
        ps.setTimestamp(4, data);
        ps.setLong(5, id_utente);

        int rs = ps.executeUpdate();
        if(rs > 0) {
            b=true;
            return b;
        }
        else {
            b=false;
            return b;
        }
    }

    // update User set (flag_cancellato = 1) Where id_user = ?
    public boolean logicDelete(boolean flag_cancellato,long idUtente) throws SQLException {
        boolean b;
        Connection conn = dbConnection.creaConnessione();
        String sql = "update USER set flag_cancellato = ? where id_User = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBoolean(1,flag_cancellato);
        ps.setLong(2,idUtente);
        int rs = ps.executeUpdate();
        if(rs > 0) {
            b=true;
            return b;
        }
        else {
            b=false;
            return b;
        }
    }

    // --> cancellazione fisica
    //delete from USER where idUtente = ?
    public boolean fisicDelete(boolean flag_cancellato,long idUtente) throws SQLException {
        boolean b;
        Connection conn = dbConnection.creaConnessione();
        String sql = "delete from USER where idUtente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, idUtente);
        int rs = ps.executeUpdate();
        if(rs > 0) {
            b=true;
            return b;
        }
        else {
            b=false;
            return b;
        }
    }
}