package com.projeto.LojaIos.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;


    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "imagem_produto")
    private String imagemProduto;

    @ManyToOne
    @JoinColumn(name = "id_cor" )
    private Cor cor;

    @ManyToOne
    @JoinColumn(name = "id_tamanho")
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;


    public Item() {
    }

    public Item(int idItem) {
        this.idItem = idItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

