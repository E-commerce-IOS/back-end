package com.projeto.LojaIos.Controller;

import com.projeto.LojaIos.Models.Carrinho;
import com.projeto.LojaIos.Models.Item;
import com.projeto.LojaIos.Models.Produto;
import com.projeto.LojaIos.Models.Tamanho;
import com.projeto.LojaIos.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/item")

public class ItemController {
    @Autowired
    ItemRepository dbConn;

    @GetMapping("/")
//     Método que retorna todos os registros do banco
    public List<Item> findAllRecords(){
        return dbConn.findAll();
    }


    @Autowired
    private ItemRepository itemRepository; // Injetando o repositório correto

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        return ResponseEntity.status(201).body(savedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Item> searchById(@PathVariable int id){
        return dbConn.findById(id);
    }

    @GetMapping("/produto/{produtoId}")
    public List<Item> searchByProdutoId(@PathVariable Integer produtoId) {
        return dbConn.findByProduto_IdProduto(produtoId);
    }

    @DeleteMapping(value = "/{id}", produces = "applcation/json")
    public String delete(@PathVariable int id){
        Item item = dbConn.findById(id).get();
        dbConn.delete(item);
        return "{deleted: " + id + " }";
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Item update(@PathVariable int id, @RequestBody Item items){
        Item item = dbConn.findById(id).get();
        item.setPreco(items.getPreco());
        item.setQuantidade(items.getQuantidade());
        item.setModelo(items.getModelo());
        item.setCodigo(items.getCodigo());
        item.setImagemProduto(items.getImagemProduto());
        dbConn.save(item);
        return item;
    }


}
