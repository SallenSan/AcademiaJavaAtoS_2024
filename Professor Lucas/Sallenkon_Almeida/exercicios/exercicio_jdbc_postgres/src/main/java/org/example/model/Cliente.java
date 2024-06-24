package org.example.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    //private int fkProfissao;
    //private int codCliente;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        // this.fkProfissao = fkProfissao;
        //this.codCliente = codCliente;
    }

    public Cliente(int id, String nome) {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*public int getFkProfissao() {
        return fkProfissao;
    }

    public void setFkProfissao(int fkProfissao) {
        this.fkProfissao = fkProfissao;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", fkProfissao=" + fkProfissao +
                ", codCliente=" + codCliente +
                '}'; */

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}

