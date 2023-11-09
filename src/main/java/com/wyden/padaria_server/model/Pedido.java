package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

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

    // Construtor que aceita uma String para o ID temporário
    public Pedido(String idTemporario) {
        // Lógica para inicializar os campos com base no ID temporário
        // Por exemplo, você pode gerar um ID numérico a partir do ID temporário.
        this.idPedido = generateNumericIdFromTemporaryId(idTemporario);
        // Inicialize outras propriedades conforme necessário
    }

    // Métodos auxiliares
    private Integer generateNumericIdFromTemporaryId(String idTemporario) {
        // Implemente a lógica para converter o ID temporário em um ID numérico
        // Por exemplo, você pode usar um hash ou alguma outra técnica de conversão
        // Este é apenas um exemplo, adapte conforme necessário
        return idTemporario.hashCode();
    }

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
