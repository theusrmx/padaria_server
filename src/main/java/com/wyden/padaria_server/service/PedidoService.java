package com.wyden.padaria_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemRepository;


    public Pedido criarPedido(Pedido pedido, List<ItemPedido> itensPedido) {
        // Salvar o pedido
        Pedido novoPedido = pedidoRepository.save(pedido);

        // Associar os itens de pedido ao pedido
        for (ItemPedido item : itensPedido) {
            item.setPedido(novoPedido);
        }

        // Salvar os itens do pedido
        itemRepository.saveAll(itensPedido);

        return novoPedido;
    }
}
