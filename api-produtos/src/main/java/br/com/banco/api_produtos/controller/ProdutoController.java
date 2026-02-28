package br.com.banco.api_produtos.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.api_produtos.dto.ProdutoDTO;
import br.com.banco.api_produtos.model.Produto;
import br.com.banco.api_produtos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
    private ProdutoService service = new ProdutoService();

    @GetMapping
    public ArrayList<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto cadastrar(@RequestBody ProdutoDTO dto) {
        return service.cadastrar(dto);
    }

    @PutMapping ("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
