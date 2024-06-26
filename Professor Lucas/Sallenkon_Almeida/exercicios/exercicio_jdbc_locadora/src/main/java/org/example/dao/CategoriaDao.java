package org.example.dao;

import org.example.database.DbConnection;
import org.example.model.Categoria;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDao {

    public int create(Categoria c) {
        String sql = "INSERT INTO categoria (nome, valor) VALUES (?,?)";
        int rows = 0;
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setBigDecimal(2, c.getValor());
            rows = ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int update(Categoria c) {
        String sql = "UPDATE categoria SET nome = ?, valor = ? WHERE id = ?";
        int rows = 0;
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, c.getNome());
            ps.setBigDecimal(2, c.getValor());
            return ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public int delete(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        int rows = 0;
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
