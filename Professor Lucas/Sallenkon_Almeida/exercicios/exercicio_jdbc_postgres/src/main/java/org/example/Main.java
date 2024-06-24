package org.example;

import org.example.dao.ClienteDao;
import org.example.model.Cliente;

public class Main {
    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();

        cliente.setNome("John Wayne");
        cliente.setCpf("11111111122");
        cliente.setTelefone("42991416683");
        //clienteDao.inserirCliente(cliente);

        System.out.println(clienteDao.getCliente(6));
    }
}