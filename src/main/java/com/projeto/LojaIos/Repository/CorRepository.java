package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer> {
    Optional<Cor> findById(int idCor);


    List<Cor> findBynomeContaining(String nome);
}


