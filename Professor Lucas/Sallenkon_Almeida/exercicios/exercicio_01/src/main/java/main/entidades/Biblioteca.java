package main.entidades;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void addLivros(Livro livro) {
        livros.add(livro);
    }

    public void listaDeLivros(){
        for(Livro livro : livros){
            System.out.println(livro);

        }
    }
}
