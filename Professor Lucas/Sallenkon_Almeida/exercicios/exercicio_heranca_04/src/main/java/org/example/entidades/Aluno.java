package org.example.entidades;

public class Aluno extends Pessoa{
    private String matricula;

    public Aluno(){

    }

    public Aluno(String nome, int rg, String matricula) {
        super(nome, rg);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void mostrarDados(){
        System.out.println("\nMostrando dados do aluno");
        super.mostrarDados();
        System.out.println("Matricula: " + matricula);

    }

}
