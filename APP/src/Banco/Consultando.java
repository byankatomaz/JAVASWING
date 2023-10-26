package Banco;

import Entidades.Lanche;
import Entidades.Restaurante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Consultando {
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

    public List<Restaurante> entrandoRestaurante() {

        configInicial();
        List<Restaurante> restaurantes = session.createQuery("FROM Restaurante").list();

        for (Restaurante nome: restaurantes) {
            System.out.println(nome);
        }

        configFinal();

        return restaurantes;
    }


    public List<Lanche> entrandoCardapio(Restaurante restaurante) {

        configInicial();
        Query query = session.createQuery("FROM Lanche l WHERE l.restaurante = :restaurante");
        query.setParameter("restaurante", restaurante.getId());

        List<Lanche> lanches = query.list();

        for (Lanche nome: lanches) {
            System.out.println(nome);
        }

        configFinal();

        return lanches;
    }
}
