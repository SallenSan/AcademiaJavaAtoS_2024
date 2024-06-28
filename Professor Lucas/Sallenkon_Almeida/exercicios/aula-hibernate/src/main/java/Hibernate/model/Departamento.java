package Hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "funcionarios")
public class Departamento {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER) // indica que um departamento(one) pode ter varios funcionarios(many)
    private List<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.nome = nome;
    }


}
