package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_pedido")
    private Long idPedido;

    @Column(name = "data_hora", nullable = false)
    private Timestamp dataHora;

    @Column(name = "status_pedido", length = 50, nullable = false)
    private String statusPedido;

    @Column(name = "nome_cliente", length = 255, nullable = false)
    private String nomeCliente;

    @Column(name = "endereco_cliente", length = 255, nullable = false)
    private String enderecoCliente;

    @Column(name = "telefone_cliente", length = 255, nullable = false)
    private String telefoneCliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    public Pedido(){}

    //Getter e setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
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

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
