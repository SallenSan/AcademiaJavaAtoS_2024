package org.example;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Principal p = new Principal();

        System.out.println("Digite seu nome: ");
        p.nome = sc.nextLine();
        System.out.println("Digite seu e-mail: ");
        p.email = sc.nextLine();
        System.out.println("Digite seu telefone: ");
        p.telefone = sc.nextLine();

        p.userInfo();

        sc.close();





    }
}