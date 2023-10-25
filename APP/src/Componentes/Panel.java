package Componentes;

import Banco.Banco;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JLabel {

     Banco banco;

    public Component panel(String img){

        ImageIcon backgroundImage = new ImageIcon(img);
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

//    public List<JPanel> cardRestaurantes() {
//        banco = new Banco();
//
//        List<String> restaurantes = banco.entrandoRestaurante();
//        List<JPanel> panelsRestautante = new ArrayList<>();
//
//        for (String restaurante : restaurantes) {
//            JPanel panelNome = new JPanel();
//
//            Border border = BorderFactory.createCompoundBorder(
//                    BorderFactory.createLineBorder(Color.BLACK, 2),
//                    new EmptyBorder(10, 56, 10, 56)
//            );
//            panelNome.setBorder(border);
//
//            JLabel nome = new JLabel(restaurante);
//            panelNome.add(nome);
//
//            panelNome.setSize(600, 20);
//
//            panelsRestautante.add(panelNome);
//        }
//
//        return panelsRestautante;
//    }

    public Component cardRestaurantes() {
        banco = new Banco();

        List<String> restaurantes = banco.entrandoRestaurante();

        Box verticalBox = Box.createVerticalBox();

        for (String restaurante : restaurantes) {

            JButton button = new JButton(restaurante);

            button.setPreferredSize(new Dimension(300, 50));

            Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLACK, 2),
                    new EmptyBorder(10, 56, 10, 56)
            );

            button.setBorder(border);

            verticalBox.add(button);
            verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(verticalBox);

        scrollPane.getViewport().setBackground(new Color(70,23,26));

        return scrollPane;
    }

}