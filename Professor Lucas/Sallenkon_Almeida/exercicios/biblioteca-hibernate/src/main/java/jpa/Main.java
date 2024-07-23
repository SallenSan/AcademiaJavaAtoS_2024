package jpa;

import jpa.config.HibernateConfig;
import jpa.model.Autor;
import jpa.model.Categoria;
import jpa.model.Editora;
import jpa.model.Livro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Autor autor = new Autor();
            autor.setNome("Arthur Conan Doyle");
            session.save(autor);

            Categoria categoria = new Categoria();
            categoria.setTipo("Suspense");
            session.save(categoria);

            Editora editora = new Editora();
            editora.setNome("Simon & Schuster");
            session.save(editora);

            Livro livro = new Livro();
            livro.setTitulo("The hound of the Baskervilles");
            livro.setIsbn("13: 9780689835711");
            livro.setAutor(autor);
            livro.setCategoria(categoria);
            livro.setEditora(editora);
            session.save(livro);

            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        HibernateConfig.closeSessionFactory();
    }
}