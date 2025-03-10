package com.example.demo.repository;

import com.example.demo.model.RegistroHabito;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroHabitoRepository extends JpaRepository<RegistroHabito, Long> {
    List<RegistroHabito> findByUsuario(Usuario usuario); // Obtener registros de un usuario específico
}
