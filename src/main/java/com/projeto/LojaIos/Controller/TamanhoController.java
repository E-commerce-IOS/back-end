package com.projeto.LojaIos.Controller;

import com.projeto.LojaIos.Models.Tamanho;
import com.projeto.LojaIos.Repository.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tamanho")

public class TamanhoController {

    @Autowired
    TamanhoRepository dbConn;

    @GetMapping("/")
    public List<Tamanho> findAllRecords(){
        return dbConn.findAll();
    }

    @PostMapping(produces = "application/json")
    public Tamanho create(@RequestBody Tamanho tamanho){
        dbConn.save(tamanho);
        return tamanho;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Tamanho> searchById(@PathVariable int id){
        return dbConn.findById(id);
    }

    @RequestMapping(value = "/descricao/{descricao}", method = RequestMethod.GET)
    public List<Tamanho> searchByName(@PathVariable String descricao) {
        return dbConn.findBydescricaoContaining(descricao);
    }

    @DeleteMapping(value = "/{id}", produces = "applcation/json")
    public String delete(@PathVariable int id){
        Tamanho tamanho = dbConn.findById(id).get();
        dbConn.delete(tamanho);
        return "{deleted: " + id + " }";
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Tamanho update(@PathVariable int id, @RequestBody Tamanho tamanhos){
        Tamanho tamanho = dbConn.findById(id).get();
        tamanho.setAlturaTamanho(tamanhos.getAlturaTamanho());
        tamanho.setLarguraTamanho(tamanhos.getLarguraTamanho());
        tamanho.setDescricao(tamanhos.getDescricao());
        dbConn.save(tamanho);
        return tamanho;
    }

}
