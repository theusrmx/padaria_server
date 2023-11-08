package com.wyden.padaria_server.controller;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping("/adicionar-item")
    public ItemPedido criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.criarItemPedido(itemPedido);
    }

    @GetMapping("/{id}")
    public ItemPedido obterItemPedido(@PathVariable Long id) {
        return itemPedidoService.obterItemPedido(id);
    }

    @GetMapping
    public List<ItemPedido> listarItemPedidos() {
        return itemPedidoService.listarItemPedidos();
    }

    @PutMapping("/{id}")
    public void atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        itemPedidoService.atualizarItemPedido(id, itemPedido);
    }

    @DeleteMapping("/{id}")
    public void deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
    }
}
