package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    private int id=1;

    @Column(name = "name")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "num")
    private Integer num;

    @Column(name = "cep")
    private Integer cep;


    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Lanche> cardapio = new ArrayList<>();

    public Restaurante() {
    }

    public Restaurante(String nome, String email, String senha, String cnpj, String endereco, int num, int cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.num = num;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public ArrayList<Lanche> getCardapio() {
        return (ArrayList<Lanche>) cardapio;
    }

    public void setCardapio(List<Lanche> cardapio) {
        this.cardapio = cardapio;
    }

    public void adicionarLanche(){
    }

    public void removerLanche(){

    }



    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", num=" + num +
                ", cep=" + cep +
//                ", cardapio=" + cardapio +
                '}';
    }
}
