package com.wyden.padaria_server.repository;

import com.wyden.padaria_server.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    @Query("SELECT p FROM Produtos p " +
            "WHERE " +
            ":dayOfWeek = 1 AND p.domingoDisponivel = true OR " +
            ":dayOfWeek = 2 AND p.segundaDisponivel = true OR " +
            ":dayOfWeek = 3 AND p.tercaDisponivel = true OR " +
            ":dayOfWeek = 4 AND p.quartaDisponivel = true OR " +
            ":dayOfWeek = 5 AND p.quintaDisponivel = true OR " +
            ":dayOfWeek = 6 AND p.sextaDisponivel = true OR " +
            ":dayOfWeek = 7 AND p.sabadoDisponivel = true")
    List<Produtos> acessarCardapioDia(@Param("dayOfWeek") int dayOfWeek);
}
