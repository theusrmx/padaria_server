package com.wyden.padaria_server.repository;

import com.wyden.padaria_server.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
