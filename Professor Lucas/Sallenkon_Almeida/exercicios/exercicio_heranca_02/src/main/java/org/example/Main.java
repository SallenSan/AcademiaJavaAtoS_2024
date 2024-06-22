package org.example;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Principal principal = new Principal();

        System.out.println("Digite o nome: ");
        principal.setNome(sc.nextLine());
        System.out.println("Digite a idade: ");
        principal.setIdade(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite o tipo: ");
        principal.setTipo(sc.nextLine());

        principal.informacoes();

        System.out.println();
        
        principal.falar();
        principal.andar();

        sc.close();
    }

}