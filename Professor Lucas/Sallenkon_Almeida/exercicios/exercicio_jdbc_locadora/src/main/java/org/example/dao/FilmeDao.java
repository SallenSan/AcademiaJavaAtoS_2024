package org.example.dao;


import org.example.database.DbConnection;
import org.example.model.Categoria;
import org.example.model.Filme;
import org.example.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    public int inserirFilme(Filme filme) {
        String query = "INSERT INTO filme (titulo_original, titulo, quantidade, id_categoria, id_genero) VALUES (?, ?, ?, ?, ?)";
        int rows = 0;
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, filme.getTituloOriginal());
            ps.setString(2, filme.getTitulo());
            ps.setInt(3, filme.getQuantidade());
            ps.setInt(4, filme.getCategoria().getId());
            ps.setInt(5, filme.getGenero().getId());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public void atualizarFilme(Filme filme) {
        String query = "UPDATE filme SET titulo_original = ?, titulo = ?, quantidade = ?, id_categoria = ?, id_genero = ? WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, filme.getTituloOriginal());
            ps.setString(2, filme.getTitulo());
            ps.setInt(3, filme.getQuantidade());
            ps.setInt(4, filme.getCategoria().getId());
            ps.setInt(5, filme.getGenero().getId());
            ps.setInt(6, filme.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Filme atualizado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Filme buscarPorId(int id) {
        String query = "SELECT * FROM filme f " +
                "JOIN categoria c ON f.id_categoria = c.id " +
                "JOIN genero g ON f.id_genero = g.id " +
                "WHERE f.id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String tituloOriginal = rs.getString("titulo_original");
                String titulo = rs.getString("titulo");
                int quantidade = rs.getInt("quantidade");
                int idCategoria = rs.getInt("id_categoria");
                String nomeCategoria = rs.getString("nome_categoria"); // assumindo que 'nome_categoria' é o nome da coluna na tabela categoria
                Categoria categoria = new Categoria(idCategoria, nomeCategoria);
                int idGenero = rs.getInt("id_genero");
                String nomeGenero = rs.getString("nome_genero"); // assumindo que 'nome_genero' é o nome da coluna na tabela genero
                Genero genero = new Genero(idGenero, nomeGenero);
                return new Filme(id, tituloOriginal, titulo, quantidade, categoria, genero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Filme> listarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        String query = "SELECT * FROM filme f " +
                "JOIN categoria c ON f.id_categoria = c.id " +
                "JOIN genero g ON f.id_genero = g.id";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tituloOriginal = rs.getString("titulo_original");
                String titulo = rs.getString("titulo");
                int quantidade = rs.getInt("quantidade");
                int idCategoria = rs.getInt("id_categoria");
                String nomeCategoria = rs.getString("nome_categoria"); // assumindo que 'nome_categoria' é o nome da coluna na tabela categoria
                Categoria categoria = new Categoria(idCategoria, nomeCategoria);
                int idGenero = rs.getInt("id_genero");
                String nomeGenero = rs.getString("nome_genero"); // assumindo que 'nome_genero' é o nome da coluna na tabela genero
                Genero genero = new Genero(idGenero, nomeGenero);
                Filme filme = new Filme(id, tituloOriginal, titulo, quantidade, categoria, genero);
                filmes.add(filme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    public void deletarFilme(int id) {
        String query = "DELETE FROM filme WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Filme deletado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

