package Hibernate.dao;

import Hibernate.interfacesDao.FuncionarioDao;
import Hibernate.model.Departamento;
import Hibernate.model.Funcionario;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import static Hibernate.dao.HibernateConfig.inSession;

public class FuncionarioImpl implements FuncionarioDao {
  private SessionFactory factory = HibernateConfig.getSessionFactory();
  private List<Funcionario> funcionarios = new ArrayList<>();
  Funcionario funcionario;

    public void save(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.persist(funcionario);
        });
    }

    public void update(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.merge(funcionario);
        });
    }

    public List<Funcionario> findAll() {
        inSession(factory, entityManager -> {
            funcionarios = entityManager.createQuery("from Funcionario", Funcionario.class).getResultList();
        });
        return funcionarios;
    }

    public Funcionario findById(int id) {
        inSession(factory, entityManager -> {
            funcionario = entityManager.find(Funcionario.class, id);
        });
        return funcionario;
    }
    public void delete(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.remove(funcionario);
        });
    }
}
