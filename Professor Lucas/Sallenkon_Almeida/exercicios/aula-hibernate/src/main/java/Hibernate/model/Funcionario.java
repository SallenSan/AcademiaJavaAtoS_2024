package Hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"departamento", "projeto"})
public class Funcionario {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String nome;
    @Column(nullable=false)
    private String cargo;

    @JoinColumn(nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)// indica que varios funcionarios podem fazer parte de um departamento
    private Departamento departamento;

    @JoinColumn(nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Projeto projeto;

    public Funcionario(String nome) {
        this.nome = nome;
    }

}
