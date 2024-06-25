package org.example.dao;


import org.example.database.DbConnection;
import org.example.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    public int inserirCliente(Cliente cliente){
        String query = "insert into cliente ( nome, cpf, telefone) VALUES (?, ?, ?)";
        int rows = 0;
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            //ps.setInt(4, cliente.getFkProfissao());
            rows = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    public int alterarCliente(Cliente cliente){
        String query = "update Cliente set Name = ?, Telefone = ? where Id = ?";
        int rows = 0;
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            //ps.setInt(3, cliente.getCodCliente());
            return ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int excluirCliente(int id){
        String query = "delete from cliente where Id = ?";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Cliente getCliente(Long id){
        String query = "select * from cliente where cod_cliente = ?";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getLong("cod_cliente");
                String nome = rs.getString("Nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("Telefone");
                return new Cliente(id, nome, cpf, telefone);
            }
        }catch (SQLException e){
            e.printStackTrace();

            return null;
        }
        return null;
    }


    public List<Cliente> listarCliente(){
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";
        try(Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cliente c = new Cliente();
               // c.setCodCliente(rs.getInt("cod_cliente"));
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
               // c.setFkProfissao(rs.getInt("fk_profissao"));
                clientes.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        for(Cliente cliente : clientes){
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Cpf: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("-----------------------------");
        }

        return clientes;

    }


}
