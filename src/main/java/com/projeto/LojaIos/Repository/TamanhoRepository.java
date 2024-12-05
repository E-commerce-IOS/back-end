package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Cor;
import com.projeto.LojaIos.Models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, Integer> {
    Optional<Tamanho> findById(int idTamanho);

    List<Tamanho> findBydescricaoContaining(String descricao);
}
