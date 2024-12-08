package com.projeto.LojaIos.Controller;


import com.projeto.LojaIos.Models.Produto;
import com.projeto.LojaIos.Models.Usuario;
import com.projeto.LojaIos.Models.UsuarioLogin;
import com.projeto.LojaIos.Repository.UsuarioRepository;
import com.projeto.LojaIos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository dbConn;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }


    @GetMapping(value = "/{id}")
    public Optional<Usuario> searchById(@PathVariable int id){
        return dbConn.findById(id);
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> postUsuario(@RequestBody @Valid Usuario usuario) {

        return usuarioService.cadastrarUsuario(usuario)
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> autenticarUsuario(@RequestBody Optional<UsuarioLogin> usuarioLogin){

        return usuarioService.autenticarUsuario(usuarioLogin)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


    @RequestMapping(value = "/nome/{nomeUsuario}", method = RequestMethod.GET)
    public List<Usuario> searchByName(@PathVariable String nomeUsuario) {
        return dbConn.findBynomeUsuarioContaining(nomeUsuario);
    }

    @DeleteMapping(value = "/{id}", produces = "applcation/json")
    public String delete(@PathVariable int id){
        Usuario usuario = dbConn.findById(id).get();
        dbConn.delete(usuario);
        return "{deleted: " + id + " }";
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Usuario update(@PathVariable int id, @RequestBody Usuario usuarios){
        Usuario usuario = dbConn.findById(id).get();
        usuario.setNomeUsuario(usuarios.getNomeUsuario());
        usuario.setEmailUsuario(usuarios.getEmailUsuario());
        usuario.setSenhaUsuario(usuarios.getSenhaUsuario());
        usuario.setEnderecoUsuario(usuarios.getEnderecoUsuario());
        usuario.setAdministrador(usuarios.getAdministrador());
        dbConn.save(usuario);
        return usuario;
    }

}
