package Componentes;

import javax.swing.*;

public class TextCampCliente extends JTextField {

    JTextField nomeCliente;
    JTextField emailCliente;
    JPasswordField senhaCliente;
    JTextField cpfCliente;
    JTextField enderecoCliente;
    JTextField numCliente;
    JTextField cepCliente;

    private Placeholder placeholder = new Placeholder();

    public void geralConfig(JTextField text){
        text.setVisible(true);
    }

    public JTextField nomeCliente(){
        nomeCliente = new JTextField();
        nomeCliente.setBounds(67, 350, 238, 31);
        placeholder.geralConfig(nomeCliente, "Nome do Cliente");
        geralConfig(nomeCliente);
        return nomeCliente;
    }

    public JTextField emailCliente(){
        emailCliente = new JTextField();
        emailCliente.setBounds(67, 401, 238, 31);
        placeholder.geralConfig(emailCliente, "Email do Cliente");
        geralConfig(emailCliente);
        return emailCliente;
    }

    public JPasswordField senhaCliente(){
        senhaCliente = new JPasswordField();
        senhaCliente.setBounds(67, 452, 238, 31);
        placeholder.geralConfig(senhaCliente, "Senha");
        geralConfig(senhaCliente);
        return senhaCliente;
    }

    public JTextField cpfCliente(){
        cpfCliente = new JTextField();
        cpfCliente.setBounds(67, 503, 238, 31);
        placeholder.geralConfig(cpfCliente, "CPF do Cliente");
        geralConfig(cpfCliente);
        return cpfCliente;
    }

    public JTextField enderecoCliente(){
        enderecoCliente = new JTextField();
        enderecoCliente.setBounds(67, 554, 238, 31);
        placeholder.geralConfig(enderecoCliente, "Endereço do Cliente");
        geralConfig(enderecoCliente);
        return enderecoCliente;
    }

    public JTextField numCliente(){
        numCliente = new JTextField();
        numCliente.setBounds(67, 605, 238, 31);
        placeholder.geralConfig(numCliente, "Numero");
        geralConfig(numCliente);
        return numCliente;
    }

    public JTextField cepCliente(){
        cepCliente = new JTextField();
        cepCliente.setBounds(67, 656, 238, 31);
        placeholder.geralConfig(cepCliente, "CEP");
        geralConfig(cepCliente);
        return cepCliente;
    }

}
