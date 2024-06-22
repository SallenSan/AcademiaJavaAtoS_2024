package org.example;

import org.example.entidades.CadastroDeFuncionario;
import org.example.entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroDeFuncionario cadastroDeFuncionario = new CadastroDeFuncionario(sc);

        List<Funcionario> funcionarios = new ArrayList<>(cadastroDeFuncionario.cadastrarFuncionario());
        cadastroDeFuncionario.listarFuncionarios(funcionarios);

        sc.close();
    }
}