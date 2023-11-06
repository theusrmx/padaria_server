package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_item_pedido")
    private Long id;

    @Column(name = "nome_item", length = 255, nullable = false)
    private String nomeItem;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "ID_pedido", nullable = false)
    private Pedido pedido;

    public ItemPedido(){}

    //Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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

    public com.wyden.padaria_server.model.Pedido getPedido() {
        return pedido;
    }

    public void setPedido(com.wyden.padaria_server.model.Pedido pedido) {
        this.pedido = pedido;
    }
}
