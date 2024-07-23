package org.example.dao;

import org.example.database.DbConnection;
import org.example.model.Dependente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DependenteDao {
    public int inserirDependente(Dependente dependente) {
        String query = "INSERT INTO dependente (fk_cliente, parentesco) VALUES (?, ?)";
        int rows = 0;
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, dependente.getCliente().getId());
            ps.setString(2, dependente.getParentesco());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }


    public void alterarDependente(Dependente dependente) {
        String query = "UPDATE dependente SET parentesco = ? WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, dependente.getParentesco());
            ps.setLong(2, dependente.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Dependente alterado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Dependente getDependente(Long id) {
        String query = "SELECT * FROM dependente WHERE cod_dependente = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String parentesco = rs.getString("parentesco");
                // Aqui você pode construir e retornar um objeto Dependente com os dados do ResultSet
                return new Dependente(id, parentesco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Dependente> listarDependentes() {
        List<Dependente> dependentes = new ArrayList<>();
        String query = "SELECT * FROM dependente";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("cod_dependente");
                String parentesco = rs.getString("parentesco");
                // Construa o objeto Dependente com os dados do ResultSet
                Dependente dependente = new Dependente(id, parentesco);
                dependentes.add(dependente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependentes;
    }



    public int deletarDependente(Long id) {
        String query = "DELETE FROM dependente WHERE cod_dependente = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
