package main;

import main.entidades.Biblioteca;
import main.entidades.Livro;

public class Main {
    public static void main(String[] args) {

        //Criando os livros
        Livro livro1 = new Livro("Drácula", "Bram Stoker", 1897);
        Livro livro2 = new Livro("Sherlock Holmes - Um estudo em vermelho", "Arthur Conan Doyle",1887 );
        Livro livro3 = new Livro("Frankenstein", "Mary Shelley", 1818);
        Livro livro4 = new Livro("Como fazer amigos e influenciar pessoas", "Dale Carnagie", 1936);

        //Criando uma biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLivros(livro1);
        biblioteca.addLivros(livro2);
        biblioteca.addLivros(livro3);
        biblioteca.addLivros(livro4);

        System.out.println("Livros disponiveis na biblioteca: ");
        biblioteca.listaDeLivros();

    }
}
