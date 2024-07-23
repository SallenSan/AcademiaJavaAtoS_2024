package org.example.model;

public class Dependente {
    private Long id;
    private Cliente cliente;
    private Cliente dependente;
    private String parentesco;

    public Dependente(Long id, String parentesco) {
    }

    public Dependente(Cliente cliente, Cliente dependente, String parentesco) {
        this.cliente = cliente;
        this.dependente = dependente;
        this.parentesco = parentesco;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getDependente() {
        return dependente;
    }

    public void setDependente(Cliente dependente) {
        this.dependente = dependente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "cliente=" + cliente +
                ", dependente=" + dependente +
                ", parentesco='" + parentesco + '\'' +
                '}';
    }


}
