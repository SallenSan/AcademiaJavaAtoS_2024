package Hibernate.dao;


import Hibernate.model.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DepartamentoDao {
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = cfg.buildSessionFactory();
    List<Departamento> departamentos = new ArrayList<>();

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
        }
        finally {
            entityMananger.close();

        }
    }

    public void save(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.persist(departamento);
        });
    }
}

