package com.wyden.padaria_server.service;

import com.wyden.padaria_server.dto.PedidoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;
import com.wyden.padaria_server.repository.ItemPedidoRepository;
import com.wyden.padaria_server.repository.PedidoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoService itemPedidoService;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

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

    public PedidoDTO getPedidoDTO(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();

            // Carrega os itens associados ao pedido usando o novo método
            List<ItemPedido> itensPedido = carregarItensDoPedidoPorId(id);

            // Cria e retorna o PedidoDTO com o Pedido e seus itens
            return new PedidoDTO(pedido, itensPedido);
        } else {
            return null;
        }
    }

    private List<ItemPedido> carregarItensDoPedidoPorId(Long pedidoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            // Retorna a lista de itens associados ao pedido
            return pedido.getItens();
        } else {
            // Se o pedido não for encontrado, retorna uma lista vazia ou lança uma exceção, dependendo dos requisitos
            return Collections.emptyList(); // ou você pode lançar uma exceção
        }
    }

    public List<PedidoDTO> obterTodosPedidosDTO() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            List<ItemPedido> itensPedido = carregarItensDoPedido(pedido.getIdPedido()); // Correção aqui
            PedidoDTO pedidoDTO = new PedidoDTO(pedido, itensPedido);
            pedidosDTO.add(pedidoDTO);
        }

        return pedidosDTO;
    }

    public List<ItemPedido> carregarItensDoPedido(Long pedidoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            return pedido.getItens();
        } else {
            // Se o pedido não for encontrado, você pode retornar uma lista vazia ou lançar uma exceção, dependendo dos requisitos
            return Collections.emptyList(); // ou você pode lançar uma exceção
        }
    }

    public PedidoDTO editarStatusPedido(Long pedidoId, String novoStatus) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();

            // Atualiza o status do pedido
            pedido.setStatusPedido(novoStatus);

            // Salva as alterações no banco de dados
            pedidoRepository.save(pedido);

            // Retorna o PedidoDTO atualizado
            return new PedidoDTO(pedido, carregarItensDoPedidoPorId(pedidoId));
        } else {
            return null;
        }
    }



}
