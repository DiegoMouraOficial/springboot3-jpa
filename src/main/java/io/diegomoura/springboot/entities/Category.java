package io.diegomoura.springboot.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="tb_category")
public class Category implements Serializable {
    private static final long serialVesrionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //#region ...Construtores
    public Category() {}
    public Category(Long id, String name){
        this.id = id;
        this.name = name;
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
    //#endregion

    //#region ...Equals Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //#endregion
}
