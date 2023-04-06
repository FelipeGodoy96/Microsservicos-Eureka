package com.moraldog.MS2Projects.dto;

import org.hibernate.mapping.List;

public class ProjetoDTO {

    private Integer id;

    private String nome;

    private String descricao;

    private Double orcamento;

    private Integer responsavel_id;

    private List tarefas;

    public ProjetoDTO() {
    }

    public ProjetoDTO(Integer id, String nome, String descricao, Double orcamento, Integer responsavel_id, List tarefas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.responsavel_id = responsavel_id;
        this.tarefas = tarefas;
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

    public List getTarefas() {
        return tarefas;
    }

    public void setTarefas(List tarefas) {
        this.tarefas = tarefas;
    }
}
