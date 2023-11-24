package com.wyden.padaria_server.service;

import com.wyden.padaria_server.model.Produtos;
import com.wyden.padaria_server.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private AuthService authService;

    public List<Produtos> getTodosProdutos(){
        return repository.findAll();
    }

    public Produtos criarNovoProduto(Produtos novoProduto) {
        return repository.save(novoProduto);
    }

    public Produtos obterProdutoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean excluirProduto(Long id) {
        // Verifique se o produto com o ID especificado existe
        Optional<Produtos> produtoOptional = repository.findById(id);

        if (produtoOptional.isPresent()) {
            // O produto existe, pode ser excluído
            repository.deleteById(id);
            return true;
        } else {
            // O produto não foi encontrado, não pode ser excluído
            return false;
        }
    }

    public List<Produtos> acessarCardapioDia() {
        // Obter o dia da semana atual (onde 1 é domingo, 2 é segunda-feira, etc.)
        int diaAtualSemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        // Executar a consulta personalizada com o dia da semana atual
        return repository.acessarCardapioDia(diaAtualSemana);
    }

    public boolean usuarioTemPermissao(String token) {
        String role = authService.getRoleFromToken(token);
        // Lógica para verificar se o usuário tem a permissão necessária
        return "ADMIN".equals(role);
    }
}
