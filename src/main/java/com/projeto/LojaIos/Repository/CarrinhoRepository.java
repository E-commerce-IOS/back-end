package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Carrinho;
import com.projeto.LojaIos.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    Optional<Carrinho> findById(int idCarrinho);

    List<Carrinho> findByUsuario_IdUsuario(Integer idUsuario);
}
