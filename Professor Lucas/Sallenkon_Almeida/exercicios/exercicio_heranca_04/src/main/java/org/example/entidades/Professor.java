package org.example.entidades;

public class Professor extends Pessoa{
    private String matricula;
    private double salario;

    public Professor() {

    }

    public Professor(String nome, int rg, String matricula, double salario) {
        super(nome, rg);
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarDados(){
        System.out.println("\nMostrando dados do professor");
        super.mostrarDados();
        System.out.println("Matricula: " + matricula);
        System.out.println("Salario: " + salario);

    }

}
