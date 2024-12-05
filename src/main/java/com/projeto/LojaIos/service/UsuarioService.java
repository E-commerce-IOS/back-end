package com.projeto.LojaIos.service;

import com.projeto.LojaIos.Models.Usuario;
import com.projeto.LojaIos.Models.UsuarioLogin;
import com.projeto.LojaIos.Repository.UsuarioRepository;
import com.projeto.LojaIos.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario()).isPresent())
            return Optional.empty();

        usuario.setSenhaUsuario(criptografarSenha(usuario.getSenhaUsuario()));

        return Optional.of(usuarioRepository.save(usuario));

    }

    public Optional<Usuario> atualizarUsuario(Usuario usuario) {

        if(usuarioRepository.findById(usuario.getIdUsuario()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getIdUsuario() != usuario.getIdUsuario()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

            usuario.setSenhaUsuario(criptografarSenha(usuario.getSenhaUsuario()));

            return Optional.ofNullable(usuarioRepository.save(usuario));

        }

        return Optional.empty();

    }

    public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {

        // Gera o Objeto de autenticação
        var credenciais = new UsernamePasswordAuthenticationToken(usuarioLogin.get().getEmailUsuario(), usuarioLogin.get().getSenhaUsuario());

        // Autentica o Usuario
        Authentication authentication = authenticationManager.authenticate(credenciais);

        // Se a autenticação foi efetuada com sucesso
        if (authentication.isAuthenticated()) {

            // Busca os dados do usuário
            Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario(usuarioLogin.get().getEmailUsuario());

            // Se o usuário foi encontrado
            if (usuario.isPresent()) {

                // Preenche o Objeto usuarioLogin com os dados encontrados
                usuarioLogin.get().setIdUsuario(usuario.get().getIdUsuario());
                usuarioLogin.get().setNomeUsuario(usuario.get().getNomeUsuario());
                usuarioLogin.get().setTelefoneUsuario(usuario.get().getTelefoneUsuario());
                usuarioLogin.get().setEnderecoUsuario(usuario.get().getEnderecoUsuario());
                usuarioLogin.get().setAdministrador(usuario.get().getAdministrador());
                usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getEmailUsuario()));
                usuarioLogin.get().setSenhaUsuario("");

                // Retorna o Objeto preenchido
                return usuarioLogin;

            }

        }

        return Optional.empty();

    }

    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(senha);

    }

    private String gerarToken(String usuario) {
        return "Bearer " + jwtService.generateToken(usuario);
    }
}
