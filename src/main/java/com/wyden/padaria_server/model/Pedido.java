package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    private String idPedido;

    @Column(name = "data_pedido")
    private Date dataPedido;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "endereco_cliente")
    private String enderecoCliente;

    @Column(name = "telefone_cliente")
    private String telefoneCliente;

    @Column(name = "status_pedido")
    private String statusPedido;

    @Column(name = "total_pedido")
    private BigDecimal totalPedido;

    public Pedido(){}

    // Construtor que aceita a String para idPedido
    public Pedido(String idPedido) {
        this.idPedido = idPedido;
    }
    //getters e setters
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
