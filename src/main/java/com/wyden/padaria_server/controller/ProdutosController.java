package com.wyden.padaria_server.controller;

import com.wyden.padaria_server.model.Produtos;
import com.wyden.padaria_server.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    ProdutosService produtosService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar-produto")
    public ResponseEntity<Produtos> criarProduto(@RequestBody Produtos novoProduto) {
        Produtos produtoCriado = produtosService.criarNovoProduto(novoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> obterProdutoPorId(@PathVariable Long id) {
        Produtos produto = produtosService.obterProdutoPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("edit/{id}")
    public ResponseEntity<Void> editarProduto(@PathVariable Long id, @RequestBody Produtos produtoAtualizado) {
        Produtos produtoExistente = produtosService.obterProdutoPorId(id);

        if (produtoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Atualize os campos do produto existente com os valores do produto atualizado
        produtoExistente.setNomeProduto(produtoAtualizado.getNomeProduto());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setPrecoMedio(produtoAtualizado.getPrecoMedio());
        produtoExistente.setPrecoGrande(produtoAtualizado.getPrecoGrande());
        produtoExistente.setSegundaDisponivel(produtoAtualizado.isSegundaDisponivel());
        produtoExistente.setTercaDisponivel(produtoAtualizado.isTercaDisponivel());
        produtoExistente.setQuartaDisponivel(produtoAtualizado.isQuartaDisponivel());
        produtoExistente.setQuintaDisponivel(produtoAtualizado.isQuintaDisponivel());
        produtoExistente.setSextaDisponivel(produtoAtualizado.isSextaDisponivel());
        produtoExistente.setSabadoDisponivel(produtoAtualizado.isSabadoDisponivel());
        produtoExistente.setDomingoDisponivel(produtoAtualizado.isDomingoDisponivel());

        // Salve o produto atualizado no repositório
        produtosService.criarNovoProduto(produtoExistente);

        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/cardapio-dia")
    public List<Produtos> getProdutosPorDiaAtual() {
        return produtosService.acessarCardapioDia();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<Produtos> getTodosProdutos(){
        return produtosService.getTodosProdutos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        if (produtosService.excluirProduto(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
