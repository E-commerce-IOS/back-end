package com.projeto.LojaIos.Controller;

import com.projeto.LojaIos.Models.Cor;
import com.projeto.LojaIos.Repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cor")

public class CorController {

    @Autowired
    CorRepository dbConn;

    @GetMapping("/")
    public List<Cor> findAllRecords(){
        return dbConn.findAll();
    }

    @PostMapping(produces = "application/json")
    public Cor create(@RequestBody Cor cor){
        dbConn.save(cor);
        return cor;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cor>searchById(@PathVariable int id){
        return dbConn.findById(id);
    }

    @RequestMapping(value = "/nome/{name}", method = RequestMethod.GET)
    public List<Cor> searchByName(@PathVariable String name) {
        return dbConn.findBynomeContaining(name);
    }

    @DeleteMapping(value = "/{id}", produces = "applcation/json")
    public String delete(@PathVariable int id){
        Cor cor = dbConn.findById(id).get();
        dbConn.delete(cor);
        return "{deleted: " + id + " }";
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Cor update(@PathVariable int id, @RequestBody Cor cores){
        Cor cor = dbConn.findById(id).get();
        cor.setNome(cores.getNome());
        dbConn.save(cor);
        return cor;
    }



}
