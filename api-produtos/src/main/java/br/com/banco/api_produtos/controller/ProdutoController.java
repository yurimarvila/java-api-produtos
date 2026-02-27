package br.com.banco.api_produtos.controller;

import java.util.ArrayList;

import javax.swing.Spring;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.api_produtos.model.Produto;
import br.com.banco.api_produtos.service.ProdutoService;

@RestController
@RequestMapping ("/produtos")

public class ProdutoController {
    private ProdutoService service = new ProdutoService();

    @GetMapping
    public ArrayList<Produto> listarTodos() {
        return service.listarTodos();
    }
}
