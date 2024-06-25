package org.example;

import org.example.dao.AtorDao;
import org.example.dao.ClienteDao;
import org.example.model.Ator;
import org.example.model.Cliente;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        AtorDao atorDao = new AtorDao();
        Ator ators = new Ator();

        // cliente.setNome("John Wayne");
        // cliente.setCpf("11111111122");
        //cliente.setTelefone("42991416683");
        //clienteDao.inserirCliente(cliente);

        // System.out.println(clienteDao.listarCliente());
        ators.setNome("Ryan Reynolds");
        atorDao.inserirAtor(ators);

        List<Ator> listaAtores = atorDao.listarAtor();
        for (Ator ator : listaAtores) {
            System.out.println("Nome do ator: " + ator.getNome());
            System.out.println("-----------------------------");
        }

    }
}