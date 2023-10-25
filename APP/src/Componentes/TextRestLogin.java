package Componentes;

import javax.swing.*;

public class TextRestLogin {

    JTextField emailRestaurante;
    JPasswordField senhaRestaurante;

    private Placeholder placeholder = new Placeholder();

    public void geralConfig(JTextField text){
        text.setVisible(true);
    }

    public JTextField emailRestaurante(){
        emailRestaurante = new JTextField();
        emailRestaurante.setBounds(61, 577, 237, 31);
        placeholder.geralConfig(emailRestaurante, "Email do Restaurante");
        geralConfig(emailRestaurante);
        return emailRestaurante;
    }

    public JPasswordField senhaRestaurante(){
        senhaRestaurante = new JPasswordField();
        senhaRestaurante.setBounds(61, 628, 237, 31);
        placeholder.geralConfig(senhaRestaurante, "Senha");
        geralConfig(senhaRestaurante);
        return senhaRestaurante;
    }

}
