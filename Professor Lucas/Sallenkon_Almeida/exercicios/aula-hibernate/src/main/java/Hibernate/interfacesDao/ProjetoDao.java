package Hibernate.interfacesDao;

import Hibernate.model.Projeto;

import java.util.List;

public interface ProjetoDao {
    void save(Projeto projeto);
    void update(Projeto projeto);
    List<Projeto> findAll();
    Projeto findById(int id);
    void delete(Projeto projeto);
}
