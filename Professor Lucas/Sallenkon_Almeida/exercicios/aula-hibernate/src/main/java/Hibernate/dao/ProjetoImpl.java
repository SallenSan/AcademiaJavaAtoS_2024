package Hibernate.dao;

import Hibernate.interfacesDao.ProjetoDao;
import Hibernate.model.Projeto;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import static Hibernate.dao.HibernateConfig.inSession;

public class ProjetoImpl implements ProjetoDao {
    private SessionFactory factory = HibernateConfig.getSessionFactory();
    private List<Projeto> projetos = new ArrayList<Projeto>();
    Projeto projeto;

    public void save(Projeto projeto) {
        inSession(factory, entityManager -> {
            entityManager.persist(projeto);
        });
    }

    public void update(Projeto projeto) {
        inSession(factory, entityManager -> {
            entityManager.merge(projeto);
        });
    }

    public List<Projeto> findAll() {
        inSession(factory, entityManager -> {
            projetos = entityManager.createQuery("from Projeto").getResultList();
        });
        return projetos;
    }
    public Projeto findById(int id) {
        inSession(factory, entityManager -> {
            projeto = entityManager.find(Projeto.class, id);
        });
        return projeto;
    }
    public void delete(Projeto projeto) {
        inSession(factory, entityManager -> {

        });
    }
}
