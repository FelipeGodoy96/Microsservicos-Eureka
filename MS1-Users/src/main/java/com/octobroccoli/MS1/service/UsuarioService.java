package com.octobroccoli.MS1.service;

import com.octobroccoli.MS1.dto.ProjetoDTO;
import com.octobroccoli.MS1.dto.UsuarioDTO;
import com.octobroccoli.MS1.http.ProjetosFeignClient;
import com.octobroccoli.MS1.model.Usuario;
import com.octobroccoli.MS1.model.exception.ResourceNotFoundException;
import com.octobroccoli.MS1.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    ProjetosFeignClient projetosRepository;

    public List<UsuarioDTO> obterTodosUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream().map(usuario -> new ModelMapper().map(usuario, UsuarioDTO.class)).collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> obterUsuarioPorId(Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            throw new ResourceNotFoundException("Usuário especificado não encontrado");
        }
        UsuarioDTO dto = new ModelMapper().map(usuario.get(), UsuarioDTO.class);
        // Instancio uma lista de projetos chamando dependencia/repository de projetos.
        List <ProjetoDTO> projetos = projetosRepository.obterProjetos(id);
        // Passo a lista obtida para o objeto dto através do método Set.
        dto.setProjetos(projetos);
        return Optional.of(dto);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDto) {
        usuarioDto.setId(null); // Limpa ID para garantir cadastro de novo usuário.
        Usuario usuario = new ModelMapper().map(usuarioDto, Usuario.class);
        usuario = repository.save(usuario);
        return new ModelMapper().map(usuario, UsuarioDTO.class);
    }

    public void deletarUsuario(Integer id) {
        if (obterUsuarioPorId(id).isEmpty()) {
            throw new ResourceNotFoundException("Usuário especificado não existe");
        }
        repository.deleteById(id);
    }

    public UsuarioDTO atualizarUsuario(Integer id, UsuarioDTO usuarioDto) {
        if (obterUsuarioPorId(id).isEmpty()) {
            throw new ResourceNotFoundException("Usuário especificado não existe");
        }
        usuarioDto.setId(id);
        Usuario usuario = new ModelMapper().map(usuarioDto, Usuario.class);
        repository.deleteById(id);
        Usuario usuarioAtualizado = repository.save(usuario);
        return new ModelMapper().map(usuarioAtualizado, UsuarioDTO.class);
    }

}
