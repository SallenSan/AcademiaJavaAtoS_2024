package entidade;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nomeTurma;
    private String codigo;
    private List<Aluno> alunos;

    public Turma(String nome, String codigo) {
        this.nomeTurma = nome;
        this.codigo = codigo;
        this.alunos = new ArrayList<>();
    }

    public void addAlunos(Aluno aluno){
        alunos.add(aluno);
    }

    public void listaDeAluno(){
        System.out.println("Alunos da " + nomeTurma +   codigo + ":");
        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }
    }
}
