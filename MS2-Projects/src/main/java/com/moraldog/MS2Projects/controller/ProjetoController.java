package com.moraldog.MS2Projects.controller;

import com.moraldog.MS2Projects.dto.ProjetoDTO;
import com.moraldog.MS2Projects.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjetoController {

    @Autowired
    ProjetoService service;

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> obterTodosProjetos() {
        List<ProjetoDTO> projetos = service.obterTodosProjetos();
        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjetoDTO>> obterProjetoPorId(@PathVariable Integer id) {
        Optional<ProjetoDTO> projeto = service.obterProjetoPorId(id);
        return new ResponseEntity<>(Optional.of(projeto).get(), HttpStatus.OK);
    }

    @GetMapping("/responsavel/{id}")
    public ResponseEntity<List<ProjetoDTO>> obterPorResponsável (@PathVariable Integer id) {
        List<ProjetoDTO> projetos = service.obterTodosPorResponsavel(id);
        if (projetos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrarProjeto(@RequestBody ProjetoDTO projeto) {
        projeto = service.criarProjeto(projeto);
        return new ResponseEntity<>(projeto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> apagarProjeto(@PathVariable Integer id) {
        service.deletarProjeto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> atualizarCadastroProjeto(@PathVariable Integer id, @RequestBody ProjetoDTO projeto) {
        projeto = service.atualizarProjeto(id, projeto);
        return new ResponseEntity<>(projeto, HttpStatus.OK);
    }

}
