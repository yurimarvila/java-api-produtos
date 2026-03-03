package br.com.banco.api_produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.api_produtos.model.Produto;
import br.com.banco.api_produtos.repository.ProdutoRepository;
import br.com.banco.api_produtos.dto.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto cadastrar(ProdutoDTO dto) { // Cadastrar
        Produto produto = new Produto(); // Cria um novo objeto Produto
        produto.setNome(dto.getNome()); // Define o nome do produto com base no DTO
        produto.setPreco(dto.getPreco()); // Define o preço do produto com base no DTO
        produto.setQuantidade(dto.getQuantidade()); // Define a quantidade do produto com base no DTO
        return repository.save(produto); // Retorna o produto cadastrado
    }

    // Atualizar
    public Produto atualizar(Long id, ProdutoDTO dto) {
        Produto produto = repository.findById(id).orElse(null);
        if (produto == null)
            return null;
        produto.setNome(dto.getNome()); // Define o nome do produto com base no DTO
        produto.setPreco(dto.getPreco()); // Define o preço do produto com base no DTO
        produto.setQuantidade(dto.getQuantidade()); // Define a quantidade do produto com base no DTO
        return repository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deletar(Long id) { // Deletar
        if (repository.existsById(id)) { // Verifica se o produto com o ID fornecido existe
            repository.deleteById(id); // Remove o produto do banco de dados
            return true; // Retorna true indicando que o produto foi deletado com sucesso
        }
        return false;// Retorna false indicando que o produto com o ID fornecido não foi encontrado
    }
}
