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

        @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
        @PostMapping("/checkout")
        public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
            Pedido novoPedido = pedidoService.criarPedido(pedidoDTO);
            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        }

        @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
        @GetMapping("/{id}")
        public ResponseEntity<PedidoDTO> getPedido(@PathVariable Long id) {
            PedidoDTO pedidoDTO = pedidoService.getPedidoDTO(id);

            if (pedidoDTO != null) {
                return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
        @GetMapping("/all")
        public ResponseEntity<List<PedidoDTO>> todosPedidos() {
            List<PedidoDTO> pedidosDTO = pedidoService.obterTodosPedidosDTO();

            if (!pedidosDTO.isEmpty()) {
                return new ResponseEntity<>(pedidosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

}
