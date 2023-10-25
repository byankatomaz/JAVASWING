package Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "lanches")
public class Lanche{

    @Id
    private int id=1;

    @Column(name = "name")
    private String nome;

    @Column(name = "description")
    private String descricao;

    @Column(name = "price")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "idRestaurante") // Nome da coluna que representa o restaurante na tabela de Lanche
    private Restaurante restaurante;

    public Lanche(){}

    public Lanche(String nome, String descricao, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return "Lanche:" + nome + ", " + descricao + ", " + preco;
    }
}
