package org.academy.aulaspringcrud.repository;

import org.academy.aulaspringcrud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
