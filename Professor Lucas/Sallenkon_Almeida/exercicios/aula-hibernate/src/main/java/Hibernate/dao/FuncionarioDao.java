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

public class FuncionarioDao {
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory factory = cfg.buildSessionFactory();
    List<Funcionario> funcionarios = new ArrayList<>();
    Funcionario funcionario;

    static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
        var entityMananger = factory.createEntityManager();
        var transaction = entityMananger.getTransaction();
        try {
            transaction.begin();
            work.accept(entityMananger);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            entityMananger.close();

        }
    }

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
