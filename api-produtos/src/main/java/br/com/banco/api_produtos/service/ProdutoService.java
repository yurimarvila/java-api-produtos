package br.com.banco.api_produtos.service;

import java.util.ArrayList;
import br.com.banco.api_produtos.model.Produto;
import br.com.banco.api_produtos.dto.ProdutoDTO;

public class ProdutoService {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;

    public ArrayList<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public Produto cadastrar(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(proximoId++);
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        produtos.add(produto);
        return produto;
    }
}
