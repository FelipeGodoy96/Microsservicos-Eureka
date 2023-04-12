package com.octobroccoli.MS1.controller;

import com.octobroccoli.MS1.dto.UsuarioDTO;
import com.octobroccoli.MS1.service.UsuarioService;
import com.octobroccoli.MS1.view.UsuarioResponseDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obterTodosUsuarios() {
        List<UsuarioDTO> usuarios = service.obterTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDetails>> obterUsuarioPorId(@PathVariable Integer id) {
        Optional<UsuarioDTO> usuario = service.obterUsuarioPorId(id);
        if (usuario.isPresent()) {
            UsuarioResponseDetails resposta = new ModelMapper().map(usuario.get(), UsuarioResponseDetails.class);
            return new ResponseEntity<>(Optional.of(resposta), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuario) {
        usuario = service.criarUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> apagarUsuario(@PathVariable Integer id) {
        service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarCadastroUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
        usuario = service.atualizarUsuario(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
