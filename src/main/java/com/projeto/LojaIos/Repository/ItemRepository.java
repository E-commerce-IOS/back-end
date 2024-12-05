package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Carrinho;
import com.projeto.LojaIos.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item>findById(int idItem);

    List<Item> findByProduto_IdProduto(Integer idProduto);
}
