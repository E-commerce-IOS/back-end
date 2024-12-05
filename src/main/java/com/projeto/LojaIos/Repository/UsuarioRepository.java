package com.projeto.LojaIos.Repository;

import com.projeto.LojaIos.Models.Produto;
import com.projeto.LojaIos.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findById(int idUsuario);

    List<Usuario> findBynomeUsuarioContaining(String nomeUsuario);

     Optional<Usuario> findByEmailUsuario(String emailUsuario);
}
