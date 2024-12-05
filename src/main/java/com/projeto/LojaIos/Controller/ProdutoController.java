package com.projeto.LojaIos.Controller;

import com.projeto.LojaIos.Models.Produto;

import com.projeto.LojaIos.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/produto")

public class ProdutoController {

    @Autowired
    ProdutoRepository dbConn;

    @GetMapping("/")
    //Método que retorna todos os registros do banco
    public List<Produto> findAllRecords(){
        return dbConn.findAll();
    }

    @PostMapping(produces = "application/json")
    public Produto create(@RequestBody Produto produto){
        dbConn.save(produto);
        return produto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Produto> searchById(@PathVariable int id){
        return dbConn.findById(id);
    }

    @RequestMapping(value = "/produto/{nomeProduto}", method = RequestMethod.GET)
    public List<Produto> searchByName(@PathVariable String nomeProduto) {
        return dbConn.findBynomeProdutoContaining(nomeProduto);
    }

    @DeleteMapping(value = "/{id}", produces = "applcation/json")
    public String delete(@PathVariable int id){
        Produto produto = dbConn.findById(id).get();
        dbConn.delete(produto);
        return "{deleted: " + id + " }";
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Produto update(@PathVariable int id, @RequestBody Produto produtos){
        Produto produto = dbConn.findById(id).get();
        produto.setNomeProduto(produtos.getNomeProduto());
        produto.setDescricaoProduto(produtos.getDescricaoProduto());
        produto.setCategoria(produtos.getCategoria());
        produto.setLancamento(produtos.getLancamento());
        dbConn.save(produto);
        return produto;
    }



}
