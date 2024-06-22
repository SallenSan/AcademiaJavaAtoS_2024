package main;

import entidade.Paciente;

public class Principal {
    public static void main(String[] args) {

        Paciente p1 = new Paciente(1.75, 80);
        Paciente p2 = new Paciente(1.80, 70);
        Paciente p3 = new Paciente(1.69, 60);


        p1.setNome("Thomas");
        p2.setNome("João");
        p3.setNome("Maria Eduarda");


        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}


