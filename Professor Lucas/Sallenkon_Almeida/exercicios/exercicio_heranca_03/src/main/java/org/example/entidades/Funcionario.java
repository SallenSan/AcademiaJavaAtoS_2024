package org.example.entidades;

public class Funcionario extends Pessoa{

    private String setor;
    private String cargo;
    private String funcao;

   public Funcionario(String nome, int idade, String telefone, String setor, String cargo, String funcao) {
       super(nome, idade, telefone);
       this.setor = setor;
       this.cargo = cargo;
       this.funcao = funcao;

   }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString(){
       return super.toString() + "\nsetor: " + setor + ", \ncargo: " + cargo + ", \nfuncao: " + funcao;
        }
    }
