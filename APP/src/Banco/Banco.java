package Banco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Banco {
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

    public List<String> entrandoRestaurante() {

        configInicial();

        List<String> nomes = session.createQuery("SELECT rest.nome FROM Restaurante rest").list();

        for (String nome: nomes) {
            System.out.println(nome);
        }

        return nomes;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        List<String> restaurantes = banco.entrandoRestaurante();

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        Box verticalBox = Box.createVerticalBox();

        for (String restaurante : restaurantes) {
            JPanel labelPanel = new JPanel();


            // Crie uma borda para o JPanel
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Cor e largura da borda
            labelPanel.setBorder(border);

            JLabel label = new JLabel(restaurante);
            labelPanel.add(label);

            verticalBox.add(labelPanel);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        // Crie um JScrollPane para adicionar o verticalBox
        JScrollPane scrollPane = new JScrollPane(verticalBox);

        panel.add(scrollPane);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();

    }
}
