package com.projeto.LojaIos.security;

import com.projeto.LojaIos.Models.Usuario;
import com.projeto.LojaIos.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class serDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario(username);

        if (usuario.isPresent())
            return new UserDetailslmpl(usuario.get());
        else
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);

    }
}
