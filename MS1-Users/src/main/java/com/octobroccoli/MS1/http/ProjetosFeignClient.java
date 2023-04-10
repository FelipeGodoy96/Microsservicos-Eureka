package com.octobroccoli.MS1.http;

import com.octobroccoli.MS1.dto.ProjetoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "moral-dog")
public interface ProjetosFeignClient {

    @GetMapping(path = "/projetos/{id}/lista")
    List<ProjetoDTO> obterProjetos(@PathVariable Integer id);

}
