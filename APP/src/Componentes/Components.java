package Componentes;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import Banco.Consultando;
import Banco.Logado;
import Entidades.Lanche;
import Entidades.Restaurante;

public class Components extends JLabel {
    Consultando banco;
    Buttons buttons;
    Frame frames;

    public Components(Frame frames, Buttons buttons){
        this.frames = frames;
        this.buttons = buttons;
    }


    public Component panel(String img){

        JPanel backgroundLabel = new JPanel(new BorderLayout());

        try {
            File imageFile = new File(img);
            BufferedImage image = ImageIO.read(imageFile);

            if (image != null) {
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                backgroundLabel.add(imageLabel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        backgroundLabel.setBounds(0, 0, 360, 800);
        backgroundLabel.setVisible(true);
        backgroundLabel.repaint();

        return backgroundLabel;
    }

    public Component cardRestaurantes(JFrame tela) {
        banco = new Consultando();

        List<Restaurante> restaurantes = banco.entrandoRestaurante();

        Box verticalBox = Box.createVerticalBox();

        for (Restaurante restaurante : restaurantes) {
            JButton button = buttons.restSelecionado(tela, restaurante);
            verticalBox.add(button);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(verticalBox);

        scrollPane.getViewport().setBackground(new Color(70,23,26));

        return scrollPane;
    }

    public Component cardLanches(JFrame tela, Restaurante restaurante) {
        banco = new Consultando();

        List<Lanche> lanches = banco.entrandoCardapio(restaurante);

        Box verticalBox = Box.createVerticalBox();

        for (Lanche lanche : lanches) {
            JPanel panelLanche = new JPanel();

            panelLanche.setMaximumSize(new Dimension(250, 50));

            JLabel nome = new JLabel(lanche.getNome());
            nome.setPreferredSize(new Dimension(120,40));
            panelLanche.add(nome);

            JButton adicona = buttons.addLanchePedido(lanche);
            panelLanche.add(adicona);

            JButton excluir = buttons.removeDoCardapio(tela, lanche);
            excluir.setBounds(250, 10, 20, 20 );
            panelLanche.add(excluir);

            verticalBox.add(panelLanche);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(verticalBox);

        scrollPane.getViewport().setBackground(new Color(70,23,26));

        return scrollPane;
    }

    public JLabel textName(JFrame tela, String nome){

        JLabel name = new JLabel(nome);

        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(Color.WHITE);

        tela.add(name);

        return name;
    }

}