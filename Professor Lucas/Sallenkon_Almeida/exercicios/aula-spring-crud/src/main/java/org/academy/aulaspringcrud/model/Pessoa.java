package org.academy.aulaspringcrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // isso fala para o JPA - Fazer uma tabela no banco
@Table(name = "tbl_pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 15)
    private String telefone;
}
