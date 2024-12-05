
package com.projeto.LojaIos.Models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Schema(example = "email@email.com.br")
    @Column(name = "email_usuario", nullable = false, unique = true)
    @Email(message = "O Atributo Usuário deve ser um email válido!")
    private String emailUsuario;

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @Column(name = "telefone_usuario")
    private String telefoneUsuario;

    @Column(name = "endereco_usuario")
    private String enderecoUsuario;

    @Column (name = "administrador")
    private boolean administrador;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Carrinho> carrinho;


    public Usuario() {}

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario,String telefoneUsuario, String enderecoUsuario, boolean administrador) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.enderecoUsuario = enderecoUsuario;
        this.administrador = administrador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }



    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }


}

