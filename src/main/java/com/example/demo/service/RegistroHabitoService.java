package com.example.demo.service;

import com.example.demo.model.RegistroHabito;
import com.example.demo.model.Usuario;
import com.example.demo.repository.RegistroHabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroHabitoService {

    @Autowired
    private RegistroHabitoRepository registroHabitoRepository;

    public List<RegistroHabito> getAllRegistros() {
        return registroHabitoRepository.findAll();
    }

    public List<RegistroHabito> getRegistrosByUsuario(Usuario usuario) {
        return registroHabitoRepository.findByUsuario(usuario);
    }

    public Optional<RegistroHabito> getRegistroById(Long id) {
        return registroHabitoRepository.findById(id);
    }

    public RegistroHabito saveRegistro(RegistroHabito registroHabito) {
        return registroHabitoRepository.save(registroHabito);
    }

    public void deleteRegistro(Long id) {
        registroHabitoRepository.deleteById(id);
    }
}
