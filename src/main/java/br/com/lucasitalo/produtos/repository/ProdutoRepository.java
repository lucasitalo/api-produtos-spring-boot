package br.com.lucasitalo.produtos.repository;

import br.com.lucasitalo.produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNome(String nome);
}
