package org.example;

import org.example.entidade.Pessoa;

import java.sql.SQLOutput;

public class Principal extends Pessoa {

    public Principal() {
        super();
    }

    public void informacoes() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Tipo: " + this.getTipo());
    }

}
