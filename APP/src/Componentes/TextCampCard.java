package Componentes;

import javax.swing.*;

public class TextCampCard extends JTextField {

    JTextField nome;
    JTextField descricao;
    JTextField preco;


    private Placeholder placeholder = new Placeholder();

    public void geralConfig(JTextField text){
        text.setVisible(true);
    }

    public JTextField nome(){
        nome = new JTextField();
        nome.setBounds(61, 490, 238, 31);
        placeholder.geralConfig(nome, "Nome do Lanche");
        geralConfig(nome);
        return nome;
    }

    public JTextField descricao(){
        descricao = new JTextField();
        descricao.setBounds(61, 541, 238, 31);
        placeholder.geralConfig(descricao, "Descrição breve");
        geralConfig(descricao);
        return descricao;
    }

    public JTextField preco(){
        preco = new JTextField();
        preco.setBounds(61, 592, 238, 31);
        placeholder.geralConfig(preco, "Preço");
        geralConfig(preco);
        return preco;
    }

}
