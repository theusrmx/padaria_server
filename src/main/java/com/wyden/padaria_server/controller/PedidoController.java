package com.wyden.padaria_server.controller;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;
import com.wyden.padaria_server.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrinho")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/checkout")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido, @RequestBody List<ItemPedido> itensPedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido, itensPedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }
}
