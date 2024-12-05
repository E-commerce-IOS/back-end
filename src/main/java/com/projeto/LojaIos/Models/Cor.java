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

    @OneToMany(mappedBy = "cor", cascade = CascadeType.ALL)
    private List<Item> item;

    public Cor() {}

    public Cor(int idICor) {
        this.idCor = idICor;
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
