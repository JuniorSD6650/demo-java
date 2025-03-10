package com.example.demo.controller;

import com.example.demo.model.RegistroHabito;
import com.example.demo.model.Usuario;
import com.example.demo.service.RegistroHabitoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroHabitoController {

    @Autowired
    private RegistroHabitoService registroHabitoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<RegistroHabito> getAllRegistros() {
        return registroHabitoService.getAllRegistros();
    }

    @GetMapping("/{id}")
    public Optional<RegistroHabito> getRegistroById(@PathVariable Long id) {
        return registroHabitoService.getRegistroById(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<RegistroHabito> getRegistrosByUsuario(@PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(idUsuario);
        return usuario.map(registroHabitoService::getRegistrosByUsuario).orElse(null);
    }

    @PostMapping
    public RegistroHabito createRegistro(@RequestBody RegistroHabito registroHabito) {
        return registroHabitoService.saveRegistro(registroHabito);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable Long id) {
        registroHabitoService.deleteRegistro(id);
    }
}
