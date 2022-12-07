package com.example.loja_games.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Produto  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "O atributo Descrição é obrigatório e não pode conter espaços em branco")
    @Size(min = 5, max = 50, message = " Minimo 5 e maximo 50")
    private String nome;


    @NotNull(message = "O atributo Descrição é obrigatório e não pode conter espaços em branco")
    @Size(min = 5, max = 50, message = " Minimo 5 e maximo 50")
    private String descricao;

    @NotNull(message = "O atributo Descrição é obrigatório e não pode conter espaços em branco")
    private BigDecimal preco;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Usuario usuario;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
