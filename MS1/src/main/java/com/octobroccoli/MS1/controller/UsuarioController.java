package com.octobroccoli.MS1.controller;

import com.octobroccoli.MS1.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsuarioController {

    @GetMapping
    public List<Usuario> obterUsuarios() {
        Usuario usuario = new Usuario(1, "Felipe", "email@example.com", "123456");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        return usuarios;
    }

}
