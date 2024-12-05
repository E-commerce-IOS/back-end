package com.projeto.LojaIos.Controller;


import com.projeto.LojaIos.Models.Carrinho;
import com.projeto.LojaIos.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/carrinho")

public class CarrinhoController {

    @Autowired
    CarrinhoRepository dbConn;

    @GetMapping("/")
    public List<Carrinho> findAllRecords(){
        return dbConn.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Carrinho> searchById(@PathVariable int id){
        return dbConn.findById(id);
    }
    @GetMapping("/usuario/{usuarioId}")
    public List<Carrinho> searchByUsuarioId(@PathVariable Integer usuarioId) {
        return dbConn.findByUsuario_IdUsuario(usuarioId);
    }

    @PostMapping(produces = "application/json")
    public Carrinho create(@RequestBody Carrinho carrinho){
        dbConn.save(carrinho);
        return carrinho;
    }


}
