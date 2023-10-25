package Componentes;

import javax.swing.*;

public class TextCliLogin {
    JTextField emailCliente;
    JPasswordField senhaCliente;

    private Placeholder placeholder = new Placeholder();

    public void geralConfig(JTextField text){
        text.setVisible(true);
    }

    public JTextField emailCliente(){
        emailCliente = new JTextField();
        emailCliente.setBounds(61, 577, 237, 31);
        placeholder.geralConfig(emailCliente, "Email do Cliente");
        geralConfig(emailCliente);
        return emailCliente;
    }

    public JPasswordField senhaCliente(){
        senhaCliente = new JPasswordField();
        senhaCliente.setBounds(61, 628, 237, 31);
        placeholder.geralConfig(senhaCliente, "Senha");
        geralConfig(senhaCliente);
        return senhaCliente;
    }
}
