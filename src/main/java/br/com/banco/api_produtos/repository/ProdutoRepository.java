package br.com.banco.api_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.api_produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}