package com.octobroccoli.MS1.dto;

import java.util.List;

public class UsuarioDTO {

    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private List<ProjetoDTO> projetos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nome, String email, String senha, List<ProjetoDTO> projetos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.projetos = projetos;
    }

    public List<ProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoDTO> projetos) {
        this.projetos = projetos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
