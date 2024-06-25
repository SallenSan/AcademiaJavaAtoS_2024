package org.example.dao;

import org.example.database.DbConnection;
import org.example.model.Ator;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtorDao {

    public int inserirAtor(Ator ator){
        String query = "INSERT INTO ator(nome) VALUES (?)";
        int rows = 0;
        try {
            Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);{
                ps.setString(1, ator.getNome());
                rows = ps.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public void alterarAtor(Ator ator){
        String query = "UPDATE ator SET nome = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DbConnection.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, ator.getNome());
            ps.executeUpdate();

            System.out.println("Ator alterado com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Ator getAtor(Long id){
        String query = "select * from cliente where cod_cliente = ?";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getLong("cod_cliente");
                String nome = rs.getString("Nome");
                return new Ator(id, nome);
            }
        }catch (SQLException e){
            e.printStackTrace();

            return null;
        }
        return null;
    }

    public List<Ator> listarAtor(){
        List<Ator> ators = new ArrayList<>();
        String query = "select * from ator";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ator ator = new Ator();
                ator.setNome(rs.getString("Nome"));
                ators.add(ator);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return ators;
    }

    public int deletarAtor(int id){
        String query = "DELETE FROM ator WHERE id = ?";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);

        }
    }
}
