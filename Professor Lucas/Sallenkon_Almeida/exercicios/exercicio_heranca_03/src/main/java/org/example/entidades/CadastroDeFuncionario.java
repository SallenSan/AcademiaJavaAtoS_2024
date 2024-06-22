package org.example.entidades;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDeFuncionario {
    private Scanner sc = new Scanner(System.in);

    public CadastroDeFuncionario(Scanner sc) {
        this.sc = sc;
    }

    public List<Funcionario> cadastrarFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>();

        while (true) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();
            System.out.println("Telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Setor: ");
            String setor = sc.nextLine();
            System.out.println("Cargo: ");
            String cargo = sc.nextLine();
            System.out.println("Função: ");
            String funcao = sc.nextLine();

            Funcionario funcionario = new Funcionario(nome, idade, telefone, setor, cargo, funcao);
            funcionarios.add(funcionario);

            System.out.println("Deseja realizar um novo cadastro? (s/n)");
            String resposta = sc.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }

        }
        return funcionarios;

    }

    public void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\nlista de funcionários: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    }

