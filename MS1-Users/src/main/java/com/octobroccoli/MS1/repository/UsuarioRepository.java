package com.octobroccoli.MS1.repository;
import com.octobroccoli.MS1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
