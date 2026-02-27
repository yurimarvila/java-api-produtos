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

    public Produto cadastrar(ProdutoDTO dto) { // Cadastrar
        Produto produto = new Produto(); // Cria um novo objeto Produto
        produto.setId(proximoId++); // Atribui um ID único ao produto e incrementa o próximo ID
        produto.setNome(dto.getNome()); // Define o nome do produto com base no DTO
        produto.setPreco(dto.getPreco()); // Define o preço do produto com base no DTO
        produto.setQuantidade(dto.getQuantidade()); // Define a quantidade do produto com base no DTO
        produtos.add(produto); // Adiciona o produto à lista de produtos
        return produto; // Retorna o produto cadastrado
    }

    // Atualizar
    public Produto atualizar(Long id, ProdutoDTO dto) {
        for (Produto produto : produtos) { // Percorre a lista de produtos
            if (produto.getId().equals(id)) { // Verifica se o ID do produto é igual ao ID fornecido
                produto.setNome(dto.getNome()); // Atualiza o nome do produto com base no DTO
                produto.setPreco(dto.getPreco()); // Atualiza o preço do produto com base no DTO
                produto.setQuantidade(dto.getQuantidade()); // Atualiza a quantidade do produto com base no DTO
                return produto;
            }
        }
        return null;
    }

    public Produto buscarPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    public boolean deletar(Long id) { // Deletar
        for (Produto produto : produtos) { // Percorre a lista de produtos
            if (produto.getId().equals(id)) { // Verifica se o ID do produto é igual ao ID fornecido
                produtos.remove(produto);// Remove o produto da lista
                return true;// Retorna true indicando que o produto foi deletado com sucesso
            }
        }
        return false;// Retorna false indicando que o produto com o ID fornecido não foi encontrado
    }
}
