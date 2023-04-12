package com.octobroccoli.MS1.http;

import com.octobroccoli.MS1.dto.ProjetoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Funciona como um repository
@FeignClient(name = "moral-dog")
public interface ProjetosFeignClient {

    @GetMapping(path = "/projects/responsavel/{id}")
    List<ProjetoDTO> obterProjetosPorResponsável(@PathVariable Integer id);

}
