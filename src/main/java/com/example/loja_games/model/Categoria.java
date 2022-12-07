package com.example.loja_games.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull( message = "O Id e obrigatorio")
    private Long id;

    @NotBlank(message = "O atributo Descrição é obrigatório e não pode conter espaços em branco")
    private String tipo;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProdutos(List<Produto> produto) {
        this.produto = produto;
    }
}
