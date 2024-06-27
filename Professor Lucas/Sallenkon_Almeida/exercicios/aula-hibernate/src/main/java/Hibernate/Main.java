package Hibernate;

import Hibernate.model.Departamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Aponta para o local onde se encontram as configurações feitas no hibernate.cfg.xml
        Configuration config = new Configuration().configure("/hibernate.cfg.xml");
        // cria uma factory
        SessionFactory factory = config.buildSessionFactory();
        //Cria uma nova session
        Session session = factory.openSession();
        //Inicia uma nova transaction
        session.beginTransaction();

        //Cria um novo objeto departamento
        Departamento departamento = new Departamento();
        departamento.setNome("RH");

        //Salva o novo departamento no repositório
        session.persist(departamento);

        //Confirma a transação. Caso alguma das ações dadas após beginTransacation(), de errado, todas as outras ações feitas são canceladas.
        session.getTransaction().commit();
        session.close();
        factory.close();



        }
    }
