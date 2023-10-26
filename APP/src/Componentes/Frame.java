package Componentes;

import Entidades.Lanche;
import Entidades.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Frame  {

    //Parte para mandar os dados entre Frames
    ArrayList<String> camposResta = new ArrayList<>();
    List<Lanche> camposLanches = new ArrayList<>();

    Integer loginUsuario;
    Integer restId;
    String nomeUsuario;


    //Variaveis que serão usadas durante o desenvolvimento da aplicação, as com letra maiuscula indica que ela será fixa.
    private final Imagens img = new Imagens();
    private final Integer X = 500;
    private final Integer Y = 0;
    private final Integer WIDTH = 376;
    private final Integer HEIGHT = 838;
    private final String TITLE = "Foosy";

    private final Buttons buttons = new Buttons(this);
    private final Components panel = new Components();
    private final TextCampRestaurante text = new TextCampRestaurante();
    private final TextCampCliente textCli = new TextCampCliente();
    private final TextCampCard textLanche = new TextCampCard();
    private final TextRestLogin loginRest = new TextRestLogin();
    private final TextCliLogin loginCli = new TextCliLogin();


    public Integer getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(Integer loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    Restaurante restaurante;

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Lanche> getCamposLanches() {
        return camposLanches;
    }

    public void setCamposLanches(List<Lanche> camposLanches) {
        this.camposLanches = camposLanches;
    }

    public ArrayList<String> getCamposResta() {
        return camposResta;
    }

    public void setCamposResta(ArrayList<String> camposResta) {
        this.camposResta = camposResta;
    }

    // Esse JFrame contém os comandos de configurações em comum entre os Frames.
    public void geralConfig(JFrame tela){
        tela.setLayout(null);
        tela.setBounds(X, Y, WIDTH, HEIGHT);
        tela.setResizable(false);

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.revalidate();
        tela.repaint();
    }

    // Esse JFrame é a tela inicial da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame telaInicial(){

        JFrame inicial = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(inicial);

            inicial.add(panel.panel(img.getInicialImg()));
            inicial.add(buttons.buttonTipoLog(inicial));
            inicial.add(buttons.buttonTipoCad(inicial));
        });

        return inicial;
    }

    // Esse JFrame é a tela onde mostra os tipos de Login da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame tipoLogin(){
        JFrame logins = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(logins);

            logins.add(panel.panel(img.getTipoLogImg()));
            logins.add(buttons.buttonLogClient(logins));
            logins.add(buttons.buttonLogResta(logins));
            logins.add(buttons.voltar(logins, this::telaInicial));
        });

        return logins;
    }

    // Esse JFrame é a tela onde mostra os tipos de Cadastro da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame tipoCadastro(){

        JFrame cadastros = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(cadastros);

            cadastros.add(panel.panel(img.getTipoCadImg()));
            cadastros.add(buttons.buttonCadRestaurante(cadastros));
            cadastros.add(buttons.buttonCadCliente(cadastros));
            cadastros.add(buttons.voltar(cadastros, this::telaInicial));
        });

        return cadastros;
    }

    // Esse JFrame é a tela de cadastro de Restaurantes da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame cadastroRestaurante(){
        JFrame restauranteCadastro = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {

            geralConfig(restauranteCadastro);

            restauranteCadastro.add(panel.panel(img.getCadRestaImg()));
            restauranteCadastro.add(buttons.voltar(restauranteCadastro, this::tipoCadastro));

            ArrayList<JTextField> campos = new ArrayList<>(); // Crie uma lista de JTextField
            campos.add((JTextField) restauranteCadastro.add(text.nomeRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.emailRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.senhaRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.cnpjRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.enderecoRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.numRestaurante()));
            campos.add((JTextField) restauranteCadastro.add(text.cepRestaurante()));

            restauranteCadastro.add(buttons.buttonCadCard(restauranteCadastro, campos));

        });

        return  restauranteCadastro;
    }

    public JFrame cadastroCardapio(){
        return cadastroCardapio(getRestaurante());
    }

    public JFrame cadastroCardapio(Restaurante restaurante){
        JFrame cadastroCardapio = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {

            geralConfig(cadastroCardapio);

            cadastroCardapio.add(panel.panel(img.getCadCardapio()));
            cadastroCardapio.add(buttons.voltar(cadastroCardapio, this::cadastroRestaurante));

            ArrayList<JTextField> camposLanche = new ArrayList<>(); // Crie uma lista de JTextField
            camposLanche.add((JTextField) cadastroCardapio.add(textLanche.nome()));
            camposLanche.add((JTextField) cadastroCardapio.add(textLanche.descricao()));
            camposLanche.add((JTextField) cadastroCardapio.add(textLanche.preco()));

            cadastroCardapio.add(buttons.buttonAdicionarMais(cadastroCardapio, camposLanche));

            if(restaurante != null){
                cadastroCardapio.add(buttons.finalizarLanche(cadastroCardapio, getRestaurante(), camposLanche));
            } else {
                cadastroCardapio.add(buttons.finalizarRestaurante(cadastroCardapio, getCamposResta(), camposLanche));
            }


        });

        return cadastroCardapio;
    }

    public JFrame telaSucesso(){
        JFrame sucesso = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(sucesso);
            sucesso.add(panel.panel(img.getSucesso()));
            Timer timer = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sucesso.dispose();
                    telaInicial();
                }
            });

            timer.setRepeats(false);
            timer.start();
        });
        return sucesso;
    }

    // Esse JFrame é a tela de cadastro de Clientes da aplicação, onde estou adicionandos seus componentes e retornando
    public void cadastroCliente(){
        JFrame clienteCadastro = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(clienteCadastro);

            clienteCadastro.add(panel.panel(img.getCadClientImg()));
            clienteCadastro.add(buttons.voltar(clienteCadastro, this::tipoCadastro));

            ArrayList<JTextField> campos = new ArrayList<>(); // Crie uma lista de JTextField
            campos.add((JTextField) clienteCadastro.add(textCli.nomeCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.emailCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.senhaCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.cpfCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.enderecoCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.numCliente()));
            campos.add((JTextField) clienteCadastro.add(textCli.cepCliente()));

            clienteCadastro.add(buttons.finalizarCliente(clienteCadastro, campos));
        });
    }

    // Esse JFrame é a tela de Login como Restaurante da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame entrarRestaurante(){
        JFrame entrarRestaurante = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(entrarRestaurante);

            entrarRestaurante.add(panel.panel(img.getLogRestaImg()));
            entrarRestaurante.add(buttons.voltar(entrarRestaurante, this::tipoLogin));

            ArrayList<JTextField> camposLogar = new ArrayList<>();
            camposLogar.add((JTextField) entrarRestaurante.add(loginRest.emailRestaurante()));
            camposLogar.add((JTextField) entrarRestaurante.add(loginRest.senhaRestaurante()));

            entrarRestaurante.add(buttons.buttonLogandoRest(entrarRestaurante, camposLogar));

        });

        return entrarRestaurante;
    }

    // Esse JFrame é a tela de Login como Cliente da aplicação, onde estou adicionandos seus componentes e retornando
    public JFrame entrarCliente(){
        JFrame entrarCliente = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {
            geralConfig(entrarCliente);

            entrarCliente.add(panel.panel(img.getLogClientImg()));
            entrarCliente.add(buttons.voltar(entrarCliente, this::tipoLogin));

            ArrayList<JTextField> camposLogar = new ArrayList<>();
            camposLogar.add((JTextField) entrarCliente.add(loginCli.emailCliente()));
            camposLogar.add((JTextField) entrarCliente.add(loginCli.senhaCliente()));

            entrarCliente.add(buttons.buttonLogandoCli(entrarCliente, camposLogar));
        });

        return entrarCliente;
    }


    public JFrame restaurantesCadastrados(){
        JFrame restaurantesCadastrados = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {

            restaurantesCadastrados.setBounds(X, Y, WIDTH, HEIGHT);
            restaurantesCadastrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            restaurantesCadastrados.setResizable(false);

            JPanel background = (JPanel) panel.panel(img.getRestaurantes());

            JScrollPane listRestaurante = (JScrollPane) panel.cardRestaurantes(restaurantesCadastrados);
            JLabel nameText = panel.textName(restaurantesCadastrados, getNomeUsuario());
            JButton buttonLogout = buttons.logout(restaurantesCadastrados, this::tipoLogin);

            buttonLogout.setPreferredSize(new Dimension(100, 50));
            buttonLogout.setHorizontalAlignment(SwingConstants.CENTER);

            nameText.setBounds(75, 760, 80, 30);
            listRestaurante.setBounds(48, 310, 270, 400);
            buttonLogout.setBounds(312, 758, 32, 32);

            restaurantesCadastrados.add(buttonLogout);

            restaurantesCadastrados.add(nameText);
            restaurantesCadastrados.add(listRestaurante);
            restaurantesCadastrados.add(background);

            restaurantesCadastrados.setVisible(true);

        });

        System.out.println("Pelo get do Frames: " + getLoginUsuario());
        return restaurantesCadastrados;
    }

    public JFrame cardapio(){
        JFrame lanchesCadastrados = new JFrame(TITLE);

        SwingUtilities.invokeLater(() -> {

            lanchesCadastrados.setBounds(X, Y, WIDTH, HEIGHT);
            lanchesCadastrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lanchesCadastrados.setResizable(false);

            JPanel background = (JPanel) panel.panel(img.getLanches());
            JScrollPane listLanches = (JScrollPane) panel.cardLanches(lanchesCadastrados, getRestaurante());
            JLabel nameUsu = panel.textName(lanchesCadastrados, getNomeUsuario());
            JLabel nameRest = panel.textName(lanchesCadastrados, getRestaurante().getNome());
            JButton voltar = buttons.logout(lanchesCadastrados, this::restaurantesCadastrados);
            JButton addMaisLanche = buttons.addLanche(lanchesCadastrados, getRestaurante());

            voltar.setPreferredSize(new Dimension(30, 30));
            addMaisLanche.setPreferredSize(new Dimension(127,35));;;

            nameUsu.setBounds(75, 760, 80, 30);
            nameRest.setBounds(70, 15, 200, 30);
            listLanches.setBounds(48, 200, 270, 400);
            voltar.setBounds(5, 7, 18, 15);
            addMaisLanche.setBounds(210, 92, 127, 35);

            lanchesCadastrados.add(voltar);
            lanchesCadastrados.add(addMaisLanche);
            lanchesCadastrados.add(nameUsu);
            lanchesCadastrados.add(nameRest);
            lanchesCadastrados.add(listLanches);
            lanchesCadastrados.add(background);

            lanchesCadastrados.setVisible(true);

        });

        System.out.println("Pelo get do Frames: " + getLoginUsuario());
        return lanchesCadastrados;
    }


}
