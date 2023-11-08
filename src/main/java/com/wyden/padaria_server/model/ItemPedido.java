package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_item_pedido")
    private Long idItem;

    @ManyToOne
    @JoinColumn(name = "ID_Pedido", referencedColumnName = "ID_Pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "ID_Produto", referencedColumnName = "ID_Produto")
    private Produtos produtos;

    @Column(name = "Quantidade")
    private Integer quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "Total_Item", nullable = false)
    private BigDecimal totalItem;

    public ItemPedido(){}

    //Getters e setters
    public Long getId() {
        return idItem;
    }

    public void setId(Long id) {
        this.idItem = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }
}
