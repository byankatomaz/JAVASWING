package Componentes;

import Banco.Cadastrando;
import Banco.Login;
import Entidades.Lanche;
import Entidades.Restaurante;
import Entidades.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class Buttons extends JButton {

    private Frame frames;
    Cadastrando banco = new Cadastrando();
    Login bancoLogin = new Login();
    Panel label = new Panel();
    private List<Lanche> lanchesLista = new ArrayList<>();
    private ArrayList<String> restauranteLista = new ArrayList<>();

    public Buttons(Frame frames) {
        this.frames = frames;
    }

    public void geralConfig(JButton botao){
        botao.setOpaque(true);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);

        botao.setVisible(true);
        botao.repaint();
    }

    public JButton voltar(JFrame tela, Supplier<JFrame> telaAnteriorProvider){

        JButton buttonVoltar = new JButton();
        buttonVoltar.setBounds(5, 7, 18, 15);

        geralConfig(buttonVoltar);

        buttonVoltar.addActionListener(e -> {
            JFrame telaAnterior = telaAnteriorProvider.get();

            tela.dispose();
            telaAnterior.setVisible(true);
        });

        return buttonVoltar;
    }

    public JButton buttonTipoLog(JFrame tela){
        JButton buttonEntrar = new JButton("Entrar");
        buttonEntrar.setBounds(118, 562, 123, 51);

        geralConfig(buttonEntrar);

        buttonEntrar.addActionListener(e -> {
            tela.dispose();
            frames.tipoLogin();
        });

        return buttonEntrar;
    }

    public JButton buttonTipoCad(JFrame tela){
        JButton buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setBounds(118, 634, 123, 51);

        geralConfig(buttonCadastrar);

        buttonCadastrar.addActionListener(e -> {
            tela.dispose();
            frames.tipoCadastro();
        });

        return buttonCadastrar;
    }

    public JButton buttonCadRestaurante(JFrame tela){
        JButton buttonCadRestaurante = new JButton("Cadastrar Restaurante");
        buttonCadRestaurante.setBounds(60, 627, 239, 51);

        geralConfig(buttonCadRestaurante);

        buttonCadRestaurante.addActionListener(e -> {
            tela.dispose();
            frames.cadastroRestaurante();
        });

        return buttonCadRestaurante;
    }

    public JButton buttonCadCard(JFrame tela, ArrayList<JTextField> text){
        JButton proximo = new JButton("Próximo");
        proximo.setBounds(104, 718, 152, 51);
        geralConfig(proximo);

        proximo.addActionListener(e -> {
            for (JTextField campo : text) {
                restauranteLista.add(campo.getText());
            }
            frames.setCamposResta(restauranteLista);

            tela.dispose();
            frames.cadastroCardapio();
        });

        return proximo;
    }


    public JButton buttonAdicionarMais(JFrame tela, ArrayList<JTextField> lanche){
        JButton adicionarMais = new JButton("Adicionar mais");
        adicionarMais.setBounds(80, 649, 152, 51);
        geralConfig(adicionarMais);

        adicionarMais.addActionListener(e -> {

            String nome = lanche.get(0).getText();
            String descricao = lanche.get(1).getText();
            double preco = Double.parseDouble(lanche.get(2).getText());

            Lanche lancheNovo = new Lanche(nome, descricao, preco);
            lanchesLista.add(lancheNovo);
            frames.setCamposLanches(lanchesLista);

            tela.dispose();
            frames.cadastroCardapio();
        });

        return adicionarMais;
    }



    public JButton finalizarRestaurante(JFrame tela, ArrayList<String> restauranteInstancia, ArrayList<JTextField> lanche){
        JButton finalizar = new JButton("Finalizar");
        finalizar.setBounds(104, 718, 152, 51);

        geralConfig(finalizar);

        finalizar.addActionListener(e -> {

            String nome = lanche.get(0).getText();
            String descricao = lanche.get(1).getText();
            double preco = Double.parseDouble(lanche.get(2).getText());

            Lanche lancheNovo = new Lanche(nome, descricao, preco);
            lanchesLista.add(lancheNovo);

            frames.setCamposLanches(lanchesLista);

            Restaurante restaurante = new Restaurante(restauranteInstancia.get(0),
                    restauranteInstancia.get(1),
                    restauranteInstancia.get(2),
                    restauranteInstancia.get(3),
                    restauranteInstancia.get(4),
                    Integer.parseInt(restauranteInstancia.get(5)),
                    Integer.parseInt(restauranteInstancia.get(6)));

            banco.inserirRestauranteComLanche(restaurante, frames.getCamposLanches());

            frames.camposResta.clear();
            frames.camposLanches.clear();

            tela.dispose();
            frames.telaSucesso();
        });

        return finalizar;
    }

    public JButton buttonCadCliente(JFrame tela){
        JButton buttonCadCliente = new JButton("Cadastrar Cliente");
        buttonCadCliente.setBounds(60, 555, 239, 51);

        geralConfig(buttonCadCliente);

        buttonCadCliente.addActionListener(e -> {
            tela.dispose();
            frames.cadastroCliente();
        });

        return buttonCadCliente;
    }

    public JButton finalizarCliente(JFrame tela, ArrayList<JTextField> usuarioInstancia){
        JButton finalizar = new JButton("Finalizar");
        finalizar.setBounds(104, 718, 152, 51);

        geralConfig(finalizar);

        finalizar.addActionListener(e -> {
            ArrayList<String> camposUsuario = new ArrayList<>();
            for (JTextField campo : usuarioInstancia) {
                camposUsuario.add(campo.getText());
            }

            Usuario usuario = new Usuario(
                    camposUsuario.get(0),
                    camposUsuario.get(1),
                    camposUsuario.get(2),
                    camposUsuario.get(3),
                    camposUsuario.get(4),
                    Integer.parseInt(camposUsuario.get(5)),
                    Integer.parseInt(camposUsuario.get(6))
            );

            banco.inserirUsuario(usuario);

            tela.dispose();
            frames.telaSucesso();
        });

        return finalizar;
    }

    public JButton buttonLogClient(JFrame tela){
        JButton buttonLogClient = new JButton("Entrar como Cliente");
        buttonLogClient.setBounds(60, 555, 239, 51);

        geralConfig(buttonLogClient);

        buttonLogClient.addActionListener(e -> {
            tela.dispose();
            frames.entrarCliente();
        });

        return buttonLogClient;
    }

    public JButton buttonLogResta(JFrame tela){
        JButton buttonLogResta = new JButton("Entrar como Restaurante");
        buttonLogResta.setBounds(60, 627, 239, 51);

        geralConfig(buttonLogResta);

        buttonLogResta.addActionListener(e -> {
            tela.dispose();
            frames.entrarRestaurante();
        });

        return buttonLogResta;
    }

    public JButton buttonLogandoRest(JFrame tela, ArrayList<JTextField> logando){
        JButton logar = new JButton("Entrar");
        logar.setBounds(60, 718, 239, 51);

        geralConfig(logar);

        logar.addActionListener(e -> {

            ArrayList<String> camposLogin = new ArrayList<>();
            for (JTextField campos : logando) {
                camposLogin.add(campos.getText());
            }

            boolean result = bancoLogin.entrandoRestaurante(camposLogin.get(0), camposLogin.get(1));

            if (result){
                System.out.println("ENTROU");
            }

        });

        return logar;
    }

    public JButton buttonLogandoCli(JFrame tela, ArrayList<JTextField> logando){
        JButton logar = new JButton("Entrar");
        logar.setBounds(60, 718, 239, 51);

        geralConfig(logar);

        logar.addActionListener(e -> {

            ArrayList<String> camposLogin = new ArrayList<>();
            for (JTextField campos : logando) {
                camposLogin.add(campos.getText());
            }

            boolean result = bancoLogin.entrandoCliente(camposLogin.get(0), camposLogin.get(1));

            if (result){
                System.out.println("ENTROU");
                tela.dispose();
                frames.restaurantesCadastrados();
            }

        });

        return logar;
    }




}