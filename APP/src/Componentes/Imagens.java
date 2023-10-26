package Componentes;

public class Imagens {

    private String caminho = "C:\\Users\\bybyt\\OneDrive\\Área de Trabalho\\JAVASWING\\APP\\src\\Imagens";

    private String inicialImg = caminho + "\\telaInicial.png";
    private String tipoCadImg = caminho + "\\telaTipoCad.png";
    private String tipoLogImg = caminho + "\\telaTipoLog.png";
    private String cadRestaImg = caminho + "\\telaCadResta.png";
    private String cadClientImg = caminho + "\\telaCadClient.png";
    private String logRestaImg = caminho + "\\telaLogResta.png";
    private String logClientImg = caminho + "\\telaLogClient.png";
    private String cadCardapio = caminho + "\\telaCadCard.png";
    private String sucesso = caminho + "\\telaSucesso.png";
    private String restaurantes = caminho + "\\restaurantes.png";
    private String lanches = caminho + "\\lanches.png";

    public String getInicialImg() {
        return inicialImg;
    }

    public String getTipoCadImg() {
        return tipoCadImg;
    }

    public String getTipoLogImg() {
        return tipoLogImg;
    }

    public String getCadRestaImg() {
        return cadRestaImg;
    }

    public String getCadClientImg() {
        return cadClientImg;
    }

    public String getLogRestaImg() {
        return logRestaImg;
    }

    public String getLogClientImg() {
        return logClientImg;
    }

    public String getCadCardapio() {
        return cadCardapio;
    }

    public String getSucesso() {
        return sucesso;
    }

    public String getRestaurantes() {
        return restaurantes;
    }

    public String getLanches() {
        return lanches;
    }
}
