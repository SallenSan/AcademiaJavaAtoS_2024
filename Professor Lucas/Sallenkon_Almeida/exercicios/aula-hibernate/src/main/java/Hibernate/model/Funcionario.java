package Hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Funcionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false,length=50,name="nome")
    private String nome;
    @Column(name = "salario")
    private Double salario;
    @Column
    private String cargo;

    @ManyToOne(fetch = FetchType.EAGER)// indica que varios funcionarios podem fazer parte de um departamento
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    private List<Projeto> projetos;


}
