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
       PreparedStatement ps = conn.prepareStatement("select * from USER where id_User = ?");
       ps.setLong(1, id);
       ResultSet rs = ps.executeQuery();

       while (rs.next()) {
           user.setid(rs.getLong("id_User"));
           user.setNome(rs.getString("nome"));
           user.setEmail(rs.getString("email"));
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

        return listaUtenti;
    }

    // insert into User values (idUtente, ...)
    public boolean createUser(String nome, String cognome, String email, Timestamp dataNascita) throws SQLException {

        boolean isCreated;
        Connection conn = dbConnection.creaConnessione();
        PreparedStatement ps = conn.prepareStatement("INSERT into User (nome, cognome,email, data_di_nascita) VALUES (?,?,?,?)");
        ps.setString(1, nome);
        ps.setString(2, cognome);
        ps.setString(3,email);
        ps.setTimestamp(4,dataNascita);

        int risultato= ps.executeUpdate();
        if(risultato>0){
        isCreated = true;
        }else{
            isCreated = false;
        }



        return isCreated;


    }




    // update USER set (nome,....) where ID_USER = ?
    public boolean updateUser(String nome){}

    // update User set (flag_cancellato = 1) Where id_user = ?
    public boolean logicDelete(long id){}


    // --> cancellazione fisica
}
