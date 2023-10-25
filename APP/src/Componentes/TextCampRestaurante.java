package Componentes;

import javax.swing.*;

public class TextCampRestaurante extends JTextField {

    JTextField nomeRestaurante;
    JTextField emailRestaurante;
    JPasswordField senhaRestaurante;
    JTextField cnpjRestaurante;
    JTextField enderecoRestaurante;
    JTextField numRestaurante;
    JTextField cepRestaurante;

    private Placeholder placeholder = new Placeholder();

    public void geralConfig(JTextField text){
        text.setVisible(true);
    }

    public JTextField nomeRestaurante(){
        nomeRestaurante = new JTextField();
        nomeRestaurante.setBounds(61, 350, 237, 31);
        placeholder.geralConfig(nomeRestaurante, "Nome do Restaurante");
        geralConfig(nomeRestaurante);
        return nomeRestaurante;
    }

    public JTextField emailRestaurante(){
        emailRestaurante = new JTextField();
        emailRestaurante.setBounds(61, 401, 237, 31);
        placeholder.geralConfig(emailRestaurante, "Email do Restaurante");
        geralConfig(emailRestaurante);
        return emailRestaurante;
    }

    public JPasswordField senhaRestaurante(){
        senhaRestaurante = new JPasswordField();
        senhaRestaurante.setBounds(61, 452, 237, 31);
        placeholder.geralConfig(senhaRestaurante, "Senha");
        geralConfig(senhaRestaurante);
        return senhaRestaurante;
    }

    public JTextField cnpjRestaurante(){
        cnpjRestaurante = new JTextField();
        cnpjRestaurante.setBounds(61, 503, 237, 31);
        placeholder.geralConfig(cnpjRestaurante, "CNPJ do Restaurante");
        geralConfig(cnpjRestaurante);
        return cnpjRestaurante;
    }

    public JTextField enderecoRestaurante(){
        enderecoRestaurante = new JTextField();
        enderecoRestaurante.setBounds(61, 554, 237, 31);
        placeholder.geralConfig(enderecoRestaurante, "Endereço do Restaurante");
        geralConfig(enderecoRestaurante);
        return enderecoRestaurante;
    }

    public JTextField numRestaurante(){
        numRestaurante = new JTextField();
        numRestaurante.setBounds(61, 605, 237, 31);
        placeholder.geralConfig(numRestaurante, "Numero");
        geralConfig(numRestaurante);
        return numRestaurante;
    }

    public JTextField cepRestaurante(){
        cepRestaurante = new JTextField();
        cepRestaurante.setBounds(61, 656, 237, 31);
        placeholder.geralConfig(cepRestaurante, "CEP");
        geralConfig(cepRestaurante);
        return cepRestaurante;
    }

}
