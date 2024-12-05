package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findById(int idProduto);

    List<Produto> findBynomeProdutoContaining(String nomeProduto);
}
