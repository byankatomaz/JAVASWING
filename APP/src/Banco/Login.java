package Banco;

import Entidades.Lanche;
import Entidades.Restaurante;
import Entidades.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class Login {

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

    public boolean entrandoRestaurante(String emailRestaurante, String senhaRestaurante) {

        configInicial();

        String emailRest = (String) session.createQuery("SELECT rest.email FROM Restaurante rest").uniqueResult();
        String senhaRest = (String) session.createQuery("SELECT rest.senha FROM Restaurante rest").uniqueResult();

        if (emailRestaurante.equals(emailRest)){

            System.out.println("Email esta cadastrado");

            if (senhaRestaurante.equals(senhaRest)){
                System.out.println("Senha esta correta, pode entrar");

                configFinal();

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta, tente novamente", "Senha incorreta", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Esse email não está cadastrado", "Email não cadastrado", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return false;
    }

    public Object[] entrandoCliente(String emailCli, String senhaCli) {

        configInicial();

        Query query = session.createQuery("SELECT usu.email, usu.senha, usu.nome, usu.id FROM Usuario usu WHERE usu.email = :email");
        query.setParameter("email", emailCli);

        List<Object[]> results = query.list();

        if (!results.isEmpty()) {
            Object[] result = results.get(0);
            String senhaCliente = (String) result[1];

            if (senhaCli.equals(senhaCliente)) {
                configFinal();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta, tente novamente", "Senha incorreta", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esse email não está cadastrado", "Email não cadastrado", JOptionPane.WARNING_MESSAGE);
        }

        configFinal();
        return null;
    }




}
