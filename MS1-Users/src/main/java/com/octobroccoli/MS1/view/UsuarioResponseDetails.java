package com.octobroccoli.MS1.view;

import com.octobroccoli.MS1.dto.ProjetoDTO;

import java.util.List;

public class UsuarioResponseDetails extends UsuarioResponse {

    private List<ProjetoDTO> projetos;

    public List<ProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoDTO> projetos) {
        this.projetos = projetos;
    }
}
