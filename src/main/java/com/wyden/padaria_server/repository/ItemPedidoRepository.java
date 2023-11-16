package com.wyden.padaria_server.repository;

import com.wyden.padaria_server.model.ItemPedido;
import com.wyden.padaria_server.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
