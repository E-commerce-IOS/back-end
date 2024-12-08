package com.projeto.LojaIos.Models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cor")

public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCor;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "cor", cascade = CascadeType.ALL)
    private List<Item> item;

    public Cor() {}

    public Cor(int idICor) {
        this.idCor = idICor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
