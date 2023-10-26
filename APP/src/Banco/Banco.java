package Banco;

import Entidades.Lanche;
import Entidades.Pedido;
import Entidades.Restaurante;
import Entidades.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

//public class Banco {
//    SessionFactory sessionFactory;
//    Session session;
//    Transaction transaction;
//
//    public void configInicial() {
//        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//    }
//
//
//    public void configFinal(){
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
//    }

//    public Pedido insertPedido(Integer usu, Integer rest, Integer lanc, Integer quant) {
//        configInicial();
//
//        Integer nextPrimaryKeyValue = (Integer) session.createQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM Pedido").uniqueResult();
//
//        Restaurante restaurante = session.get(Restaurante.class, rest);
//        Usuario usuario = session.get(Usuario.class, usu);
//        Lanche lanche = session.get(Lanche.class, lanc);
//
//        double precoTotal = lanche.getPreco()*quant;

//        Pedido newPedido = new Pedido(quant, precoTotal);

//        newPedido.setId(nextPrimaryKeyValue);
//        newPedido.setRestaurantes(restaurante);
//        newPedido.setUsuarios(usuario);
//        newPedido.setLanche(lanche);
//
//        session.save(newPedido);
//
//        configFinal();
//
//        return newPedido;
//    }

//    public static void main(String[] args) {
//        Banco banco = new Banco();
//
//        banco.insertPedido(1, 1, 3, 5);
//
//    }
//}
