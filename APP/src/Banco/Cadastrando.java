package Banco;

import Entidades.Lanche;
import Entidades.Pedido;
import Entidades.Restaurante;
import Entidades.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Cadastrando {

    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;

    public void configInicial() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void configFinal() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
        if (session != null && session.isOpen()) {
            session.close();
        }
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    public int inserirRestaurante(Restaurante restaurante) {

        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Restaurante").uniqueResult();

        restaurante.setId(nextPrimaryKeyValue);
        session.save(restaurante);

        int restauranteId = restaurante.getId(); // Obtenha o ID gerado

        configFinal();

        return restauranteId;
    }

    public void inserirLancheFK(Restaurante rest, List<Lanche> lanches) {
        configInicial();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Restaurante restaurante = session.get(Restaurante.class, rest.getId());

            for (Lanche lanche : lanches) {
                int lancheId = restaurante.getId() * 1000 + lanches.indexOf(lanche);
                lanche.setId(lancheId);
                lanche.setRestaurante(restaurante);
                session.save(lanche);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            configFinal();
        }
    }

    public void inserirLanche(Lanche lanche) {
        try {
            configInicial();
            Transaction transaction = session.beginTransaction();
            Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Lanche").uniqueResult();
            lanche.setId(nextPrimaryKeyValue);
            session.save(lanche);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            configFinal();
        }
    }


    public void inserirRestauranteComLanche(Restaurante restaurante, List<Lanche> lanches) {
        try {
            configInicial();
            inserirRestaurante(restaurante);
            for (Lanche lanche : lanches) {
                int lancheId = restaurante.getId() * 1000 + lanches.indexOf(lanche);
                lanche.setId(lancheId);
                lanche.setRestaurante(restaurante);
                inserirLanche(lanche);
            }
        } finally {
            configFinal();
        }
    }

    public int inserirUsuario(Usuario usuario) {
        configInicial();

        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Usuario").uniqueResult();
        usuario.setId(nextPrimaryKeyValue);

        usuario.setId(nextPrimaryKeyValue);
        session.save(usuario);

        int usuarioId = usuario.getId();

        configFinal();

        return usuarioId;
    }

    public Pedido insertPedido(Pedido pedido) {
        configInicial();

        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Pedido").uniqueResult();

        Restaurante restaurante = session.get(Restaurante.class, pedido.getRestaurantes());
        Usuario usuario = session.get(Usuario.class, pedido.getUsuarios());

        // Calcule o preço total com base na lista de lanches
        double precoTotal = 0.0;
        for (Lanche lanche : pedido.getLanche()) {
            precoTotal += lanche.getPreco() * pedido.getQuantidade();
        }

        pedido.setId(nextPrimaryKeyValue);
        pedido.setRestaurantes(restaurante);
        pedido.setUsuarios(usuario);
        pedido.setPrecoTotal(precoTotal);

        // Lembre-se de configurar a relação entre o pedido e os lanches (muitos para muitos)
        for (Lanche lanche : pedido.getLanche()) {
            pedido.getLanche().add(lanche); // Associe o pedido ao lanche
        }

        session.save(pedido);

        configFinal();

        return pedido;
    }


}
