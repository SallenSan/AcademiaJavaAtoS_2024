package org.example.dao;

import org.example.database.DbConnection;
import org.example.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

    public int inserirEndereco(Endereco endereco) {
        String query = "INSERT INTO endereco (logradouro, tipo_logradouro, complemento, cidade, uf, cep, numero, bairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = 0;
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getBairro());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public void atualizarEndereco(Endereco endereco) {
        String query = "UPDATE endereco SET logradouro = ?, tipo_logradouro = ?, complemento = ?, cidade = ?, uf = ?, cep = ?, numero = ?, bairro = ? WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getBairro());
            ps.setInt(9, endereco.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Endereço atualizado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarPorId(int id) {
        String query = "SELECT * FROM endereco WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String logradouro = rs.getString("logradouro");
                String tipoLogradouro = rs.getString("tipo_logradouro");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                return new Endereco(id, logradouro, tipoLogradouro, complemento, cidade, uf, cep, numero, bairro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> enderecos = new ArrayList<>();
        String query = "SELECT * FROM endereco";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String logradouro = rs.getString("logradouro");
                String tipoLogradouro = rs.getString("tipo_logradouro");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                Endereco endereco = new Endereco(id, logradouro, tipoLogradouro, complemento, cidade, uf, cep, numero, bairro);
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    public void deletarEndereco(int id) {
        String query = "DELETE FROM endereco WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Endereço deletado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

