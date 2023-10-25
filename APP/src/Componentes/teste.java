package Componentes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class teste extends JFrame  {

    private JPanel painelPrincipal;
    private JPanel painelSecundario;
    private JButton botaoPainelPrincipal;

    public teste() {
        super("Testando sobreposição de JPanel`s");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        exibir();
    }

    public void exibir() {

        SpringLayout layout = new SpringLayout();

        painelPrincipal = new JPanel(layout);
        painelPrincipal.setPreferredSize(new Dimension(400,400));
        painelPrincipal.setBackground(Color.BLACK);

        painelSecundario = new JPanel();
        painelSecundario.setPreferredSize(new Dimension(200,200));
        painelSecundario.setBackground(Color.BLUE);

        botaoPainelPrincipal = new JButton("OK");
        botaoPainelPrincipal.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        painelPrincipal.remove(painelSecundario);
                        painelPrincipal.repaint();
                    }
                });

        painelPrincipal.add(botaoPainelPrincipal);
        painelPrincipal.add(painelSecundario);
        add(painelPrincipal);

        setVisible(true);

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new teste();
                    }
                });
    }
}