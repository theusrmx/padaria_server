package com.wyden.padaria_server.service;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/itempedidos")
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido obterItemPedido(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public List<ItemPedido> listarItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public void atualizarItemPedido(Long id, ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    public void deletarItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
