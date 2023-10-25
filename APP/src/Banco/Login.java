package Banco;

import Entidades.Lanche;
import Entidades.Restaurante;
import Entidades.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

    public boolean entrandoCliente(String emailCli, String senhaCli) {

        configInicial();

        String emailCliente = (String) session.createQuery("SELECT usu.email FROM Usuario usu").uniqueResult();
        String senhaCliente = (String) session.createQuery("SELECT usu.senha FROM Usuario usu").uniqueResult();

        if (emailCli.equals(emailCliente)){

            System.out.println("Email esta cadastrado");

            if (senhaCli.equals(senhaCliente)){
                System.out.println("Senha esta correta, pode entrar");

                configFinal();

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta, tente novamente", "Senha incorreta", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Esse email não está cadastrado", "Email não cadastrado", JOptionPane.WARNING_MESSAGE);
            configFinal();
            return false;
        }

        return false;
    }



}
