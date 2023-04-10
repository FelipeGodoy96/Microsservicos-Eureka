package com.octobroccoli.MS1.dto;

public class ProjetoDTO {

    private Integer id;

    private String nome;

    private String descricao;

    private Double orcamento;

    private Integer responsavel_id;

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
}
