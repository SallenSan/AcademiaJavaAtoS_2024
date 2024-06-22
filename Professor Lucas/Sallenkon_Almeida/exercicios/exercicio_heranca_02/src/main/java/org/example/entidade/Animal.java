package org.example.entidade;

public class Animal {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void andar(){
        System.out.println("Todos andam, mas o modo é variado");
    }
}
