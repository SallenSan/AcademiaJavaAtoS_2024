package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Principal principal = new Principal();
        Scanner sc = new Scanner(System.in);

        System.out.println("Mensagem A: ");
        principal.exibeMensagemA();
        System.out.println("\nDigite uma mensagem para preservação do planeta: ");
        String mensagemB = sc.nextLine();

        principal.exibeMensagemA();
        principal.exibeMensagemB(mensagemB);


        sc.close();
    }
}