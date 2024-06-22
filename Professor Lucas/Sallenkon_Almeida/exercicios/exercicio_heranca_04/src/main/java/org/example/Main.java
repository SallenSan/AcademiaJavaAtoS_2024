package org.example;

import org.example.entidades.Aluno;
import org.example.entidades.Pessoa;
import org.example.entidades.Professor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // criando o professor
        Professor professor1 = new Professor();
        professor1.setNome("João");
        professor1.setMatricula("123456");
        professor1.setSalario(5000.00);
        professor1.setRg(12345678);
        professor1.mostrarDados();

        // criando o aluno
        Aluno aluno1= new Aluno();
        aluno1.setNome("Lucas");
        aluno1.setMatricula("123456");
        aluno1.setRg(12345678);
        aluno1.mostrarDados();

        // criando pessoa
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Ana");
        pessoa1.setRg(75849483);
        System.out.println("\nMostrando dados da pessoa");
        pessoa1.mostrarDados();

    }
}