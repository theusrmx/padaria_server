package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pedido")
    private Integer idPedido;

    @Column(name = "Data_Pedido")
    private Date dataPedido;

    @Column(name = "Nome_Cliente")
    private String nomeCliente;

    @Column(name = "Endereco_Cliente")
    private String enderecoCliente;

    @Column(name = "Telefone_Cliente")
    private String telefoneCliente;

    @Column(name = "status_pedido")
    private String statusPedido;

    @Column(name = "Total_Pedido")
    private BigDecimal totalPedido;

    public Pedido(){}

    //getters e setters
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
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
