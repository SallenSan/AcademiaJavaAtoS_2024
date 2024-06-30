package Hibernate.interfacesDao;

import Hibernate.model.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    List<Funcionario> findAll();
    Funcionario findById(int id);
    void delete(Funcionario funcionario);
}
