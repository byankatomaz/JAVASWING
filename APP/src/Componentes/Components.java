package Componentes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import Banco.Consultando;
import Entidades.Lanche;
import Entidades.Restaurante;

public class Components extends JLabel {
    Consultando banco;
    Buttons buttonTeste;
    Frame frames;


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
        frames = new Frame();
        buttonTeste = new Buttons(frames);
        List<Restaurante> restaurantes = banco.entrandoRestaurante();

        Box verticalBox = Box.createVerticalBox();

        for (Restaurante restaurante : restaurantes) {
            JButton button = buttonTeste.restaurantesDisponiveis(tela, restaurante);
            frames.setRestaurante(restaurante);
            verticalBox.add(button);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(verticalBox);

        scrollPane.getViewport().setBackground(new Color(70,23,26));

        return scrollPane;
    }

    public Component cardLanches(JFrame tela) {
        banco = new Consultando();
        frames = new Frame();
        buttonTeste = new Buttons(frames);
        List<Lanche> lanches = banco.entrandoCardapio(frames.getRestaurante());

        Box verticalBox = Box.createVerticalBox();

        for (Lanche lanche : lanches) {
            JButton button = buttonTeste.lanchesDisponiveis(tela, lanche);
            verticalBox.add(button);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(verticalBox);

        scrollPane.getViewport().setBackground(new Color(70,23,26));

        return scrollPane;
    }

    public JLabel textName(JFrame tela, String nameText){
        JLabel name = new JLabel(nameText);

        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(Color.WHITE);

        tela.add(name);

        return name;
    }

}