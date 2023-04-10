package com.moraldog.MS2Projects.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.mapping.List;

import java.util.Objects;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private Double orcamento;

    private Integer responsavel_id;


    public Projeto() {
    }

    public Projeto(Integer id, String nome, String descricao, Double orcamento, Integer responsavel_id) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.responsavel_id = responsavel_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public Integer getResponsavel_id() {
        return responsavel_id;
    }

    public void setResponsavel_id(Integer responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(responsavel_id, projeto.responsavel_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responsavel_id);
    }
}
