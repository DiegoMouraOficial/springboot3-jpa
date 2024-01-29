package io.diegomoura.springboot.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name ="tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private Double preco;
    private String imgUrl;
    @Transient
    private Set<Category> categories = new HashSet<>();

    //#region ...Construtores
    public Product(){}
    public Product(Long id, String name, String descricao, Double preco, String imgUrl){
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }
    //#endregion

    //#region ...Getter and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Set<Category> getCategories() {
        return categories;
    }
    //#endregion

    //#region ...Equals HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //#endregion
}





