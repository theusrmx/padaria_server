package com.wyden.padaria_server.service;

import com.wyden.padaria_server.dto.PedidoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;
import com.wyden.padaria_server.repository.ItemPedidoRepository;
import com.wyden.padaria_server.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoService itemPedidoService;

    /*
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
*/
    @Transactional
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        // Extraia o pedido e itens do pedido do DTO
        Pedido pedido = pedidoDTO.getPedido();
        List<ItemPedido> itensPedido = pedidoDTO.getItensPedido();

        // Salve o pedido
        Pedido novoPedido = pedidoRepository.save(pedido);

        // Associe os itens do pedido ao novo pedido
        for (ItemPedido item : itensPedido) {
            item.setPedido(novoPedido);
        }

        // Salve os itens do pedido
        itemPedidoService.criarItensPedido(itensPedido);

        // Retorne o novo pedido
        return novoPedido;
    }
    public Pedido obterPedido(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public void atualizarPedido(Long id, Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }



}
