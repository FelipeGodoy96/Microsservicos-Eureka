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
        List<ProjetoDTO> usuarios = service.obterTodosProjetos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjetoDTO>> obterProjetoPorId(@PathVariable Integer id) {
        Optional<ProjetoDTO> usuario = service.obterProjetoPorId(id);
        return new ResponseEntity<>(Optional.of(usuario).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrarProjeto(@RequestBody ProjetoDTO usuario) {
        usuario = service.criarProjeto(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> apagarProjeto(@PathVariable Integer id) {
        service.deletarProjeto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> atualizarCadastroProjeto(@PathVariable Integer id, @RequestBody ProjetoDTO usuario) {
        usuario = service.atualizarProjeto(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
