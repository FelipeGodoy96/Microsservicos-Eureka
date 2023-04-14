package com.octobroccoli.MS1.http;

import com.octobroccoli.MS1.dto.ProjetoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Funciona como um "repository"
@FeignClient(name = "moral-dog")  // Aqui passo o nome do microsserviço-alvo
public interface ProjetosFeignClient {

    @GetMapping(path = "/projects/responsavel/{id}")  // caminho da requisição do microsserviço-alvo quando o método for chamado
    List<ProjetoDTO> obterProjetosPorResponsável(@PathVariable Integer id);

}
