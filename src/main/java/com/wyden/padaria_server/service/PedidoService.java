package com.wyden.padaria_server.service;

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

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
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
