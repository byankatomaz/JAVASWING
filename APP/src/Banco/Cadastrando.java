package Banco;

import Entidades.Lanche;
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


    public void configFinal(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public int inserirRestaurante(Restaurante restaurante) {

        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Restaurante").uniqueResult();
        restaurante.setId(nextPrimaryKeyValue);

        restaurante.setId(nextPrimaryKeyValue);
        session.save(restaurante);

        int restauranteId = restaurante.getId(); // Obtenha o ID gerado

        configFinal();

        return restauranteId;
    }

    public int inserirLanche(Lanche lanche) {
        configInicial();

        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Lanche").uniqueResult();
        lanche.setId(nextPrimaryKeyValue);

        session.save(lanche);

        int lancheId = lanche.getId();

        configFinal();

        return lancheId;
    }

    public void inserirRestauranteComLanche(Restaurante restaurante, List<Lanche> lanches) {

        configInicial();

        inserirRestaurante(restaurante);

        for (Lanche lanche : lanches) {

            int lancheId = restaurante.getId() * 1000 + lanches.indexOf(lanche);

            lanche.setId(lancheId);
            lanche.setRestaurante(restaurante);

            inserirLanche(lanche);
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

}
