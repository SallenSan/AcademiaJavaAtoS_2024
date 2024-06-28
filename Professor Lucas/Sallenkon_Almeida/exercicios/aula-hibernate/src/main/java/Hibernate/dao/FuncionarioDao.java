package Hibernate.dao;

import Hibernate.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static Hibernate.dao.HibernateConfig.inSession;

public class FuncionarioDao {
  private SessionFactory factory = HibernateConfig.getSessionFactory();
  private List<Funcionario> funcionarios = new ArrayList<>();
  Funcionario funcionario;

    public void save(Funcionario funcionario) {
        inSession(factory, entityManager -> {
            entityManager.persist(funcionario);
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
