package com.wyden.padaria_server.controller;

import com.wyden.padaria_server.dto.PedidoDTO;
import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;
import com.wyden.padaria_server.service.ItemPedidoService;
import com.wyden.padaria_server.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    private ItemPedidoService itemPedidoService;

    /*
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/criar")
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }
     */

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
    @PostMapping("/checkout")
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido novoPedido = pedidoService.criarPedido(pedidoDTO);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Pedido obterPedido(@PathVariable Long id) {
        return pedidoService.obterPedido(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedidoService.atualizarPedido(id, pedido);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }

    /*
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/checkout")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido, @RequestBody List<ItemPedido> itensPedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido, itensPedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    */


}
