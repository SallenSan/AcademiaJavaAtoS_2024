package jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;
    private String titulo;
    private int anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "id")
    private Autor autor;

    @ManyToOne // muitos livros podem pertencer a uma editora
    private Editora editora;

    @ManyToOne //muitos livros podem pertencer a uma categoria
    private Categoria categoria;
}
