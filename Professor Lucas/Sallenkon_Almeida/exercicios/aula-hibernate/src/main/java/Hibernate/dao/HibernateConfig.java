package Hibernate.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;

public class HibernateConfig {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable e){
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
        var entityMananger = factory.createEntityManager();
        var transactionManager = entityMananger.getTransaction();
        try{
            transactionManager.begin();
            work.accept(entityMananger);
            transactionManager.commit();
        }catch(Exception e){
            if(transactionManager.isActive()) transactionManager.rollback();
            throw e;
        }finally {
            entityMananger.close();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    }

