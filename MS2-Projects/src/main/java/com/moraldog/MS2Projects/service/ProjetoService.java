package com.moraldog.MS2Projects.service;

import com.moraldog.MS2Projects.dto.ProjetoDTO;
import com.moraldog.MS2Projects.model.Projeto;
import com.moraldog.MS2Projects.repository.ProjetoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository repository;


    public List<ProjetoDTO> obterTodosProjetos() {
        List<Projeto> projetos = repository.findAll();
        return projetos.stream().map(projeto -> new ModelMapper().map(projeto, ProjetoDTO.class)).collect(Collectors.toList());
    }

    public Optional<ProjetoDTO> obterProjetoPorId(Integer id) {
        Optional<Projeto> projeto = repository.findById(id);
        if (projeto.isEmpty()) {
            throw new RuntimeException("Usuário especificado não encontrado");
        }
        ProjetoDTO dto = new ModelMapper().map(projeto.get(), ProjetoDTO.class);
        return Optional.of(dto);
    }

    public ProjetoDTO criarProjeto(ProjetoDTO projetoDto) {
        projetoDto.setId(null); // Limpa ID para garantir cadastro de novo usuário.
        Projeto projeto = new ModelMapper().map(projetoDto, Projeto.class);
        projeto = repository.save(projeto);
        return new ModelMapper().map(projeto, ProjetoDTO.class);
    }

    public void deletarProjeto(Integer id) {
        if (obterProjetoPorId(id).isEmpty()) {
            throw new RuntimeException("Usuário especificado não existe");
        }
        repository.deleteById(id);
    }

    public ProjetoDTO atualizarProjeto(Integer id, ProjetoDTO projetoDto) {
        if (obterProjetoPorId(id).isEmpty()) {
            throw new RuntimeException("Usuário especificado não existe");
        }
        projetoDto.setId(id);
        Projeto projeto = new ModelMapper().map(projetoDto, Projeto.class);
        repository.deleteById(id);
        Projeto projetoAtualizado = repository.save(projeto);
        return new ModelMapper().map(projetoAtualizado, ProjetoDTO.class);
    }

}
