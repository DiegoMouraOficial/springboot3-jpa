package io.diegomoura.springboot.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    //#region ...Construtores
    public User() {}
    public User(Long id, String nome, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    //#endregion

    //#region ...Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    //#endregion

    //#region ...Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User usuarios)) return false;
        return Objects.equals(id, usuarios.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //#endregion
}