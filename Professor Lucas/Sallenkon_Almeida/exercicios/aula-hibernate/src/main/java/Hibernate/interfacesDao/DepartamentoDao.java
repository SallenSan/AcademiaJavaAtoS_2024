package Hibernate.interfacesDao;

import Hibernate.model.Departamento;

import java.util.List;

public interface DepartamentoDao {
    void save(Departamento departamento);
    void update(Departamento departamento);
    List<Departamento> findAll();
    Departamento findById(int id);
    void delete(Departamento departamento);
}
