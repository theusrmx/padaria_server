package com.wyden.padaria_server.dto;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;

import java.util.List;

public class PedidoDTO {
    private Pedido pedido;
    private List<ItemPedido> itensPedido;

    public PedidoDTO(Pedido pedido, List<ItemPedido> itensPedido) {
        this.pedido = pedido;
        this.itensPedido = itensPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
