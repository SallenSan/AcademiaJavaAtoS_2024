package main;

import entidade.Aluno;
import entidade.Turma;

public class Main {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("João", 12, 1234);
        Aluno a2 = new Aluno("Maria", 9, 5678);
        Aluno a3 = new Aluno("Lucas", 13, 90902);
        Aluno a4 = new Aluno("Bernardo", 12, 5688);
        Aluno a5 = new Aluno("Thomas", 10, 1439);
        Aluno a6 = new Aluno("Maria Eduarda", 11, 1997);
        Aluno a7 = new Aluno("Pedro", 11, 1998);
        Aluno a8 = new Aluno("José", 11, 1947);
        Aluno a9 = new Aluno("Eduarda", 13, 1977);
        Aluno a10 = new Aluno("Benicio", 10, 1897);

        Turma t1 = new Turma("Turma ", "1°A");
        Turma t2 = new Turma("Turma ", "1°B");

        // adicionando alunos na turma A
        t1.addAlunos(a1);
        t1.addAlunos(a2);
        t1.addAlunos(a3);
        t1.addAlunos(a4);
        t1.addAlunos(a5);

        // adicionando alunos na turma B
        t2.addAlunos(a6);
        t2.addAlunos(a7);
        t2.addAlunos(a8);
        t2.addAlunos(a9);
        t2.addAlunos(a10);

        System.out.println("Lista de alunos em cada turma: ");
        t1.listaDeAluno();
        System.out.println();
        t2.listaDeAluno();

    }
}
