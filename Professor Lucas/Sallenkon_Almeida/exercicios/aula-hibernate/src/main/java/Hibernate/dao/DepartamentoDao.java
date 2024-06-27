package Hibernate.dao;
import Hibernate.model.Departamento;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;
import static Hibernate.dao.HibernateConfig.inSession;

public class DepartamentoDao {
    private SessionFactory factory = HibernateConfig.getSessionFactory();
    private List<Departamento> departamentos = new ArrayList<>();
    Departamento departamento;

    public void save(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.persist(departamento);
        });
    }

    public void update(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.merge(departamento);
        });
    }

    public List<Departamento> findAll() {
        inSession(factory, entityManager -> {
            departamentos = entityManager.createQuery("from Departamento").getResultList();
        });
        return departamentos;
    }
    public Departamento findById(int id) {
        inSession(factory, entityManager -> {
            departamento = entityManager.find(Departamento.class, id);
        });
        return departamento;
    }
    public void delete(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.remove(departamento);
        });
    }
}