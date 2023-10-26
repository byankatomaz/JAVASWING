package Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private int id=1;

    @ManyToOne
    @JoinColumn(name = "idRestaurante")
    private Restaurante restaurantes;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuarios;

    @ManyToOne
    @JoinColumn(name = "idLanche")
    private Lanche lanche;

    @Column(name = "quant")
    private Integer quantidade;

    @Column(name = "totalPrice")
    private Double precoTotal;

    public Pedido(Restaurante restaurantes, Usuario usuarios, Lanche lanche, Integer quantidade) {
        this.restaurantes = restaurantes;
        this.usuarios = usuarios;
        this.lanche = lanche;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurante getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Restaurante restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }
}
