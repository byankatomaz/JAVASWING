package Banco;

import Entidades.Lanche;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Deletando {
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;

    public void configInicial() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }


    public void configFinal(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public void deleteLanche(Lanche id) {

        configInicial();

//        Query query = session.createQuery("FROM Lanche l WHERE l.id = :lanche");
//        query.setParameter("lanche", lanches);

        Lanche lanche = session.get(Lanche.class, id);

        session.delete(lanche);

        System.out.println("deletado com sucesso");

        configFinal();
    }
}
