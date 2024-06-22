package org.example;

public class Principal extends Usuario{
    public Principal() {
    }

    public Principal(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }

    public void userInfo(){
        System.out.println("Dados do usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);

    }


}
