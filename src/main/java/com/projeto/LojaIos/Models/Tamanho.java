package com.projeto.LojaIos.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tamanho")
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTamanho;

    @Column(name = "altura_tamanho")
    private String alturaTamanho;

    @Column(name = "largura_tamanho")
    private String larguraTamanho;

   @Column(name = "descricao")
   private String descricao;

    @OneToMany(mappedBy = "tamanho", cascade = CascadeType.ALL)
    private List<Item> item;

    public Tamanho() {
    }

    public Tamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getAlturaTamanho() {
        return alturaTamanho;
    }

    public void setAlturaTamanho(String alturaTamanho) {
        this.alturaTamanho = alturaTamanho;
    }

    public String getLarguraTamanho() {
        return larguraTamanho;
    }

    public void setLarguraTamanho(String larguraTamanho) {
        this.larguraTamanho = larguraTamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
