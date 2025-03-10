package com.example.demo.controller.web;

import com.example.demo.model.Habito;
import com.example.demo.model.RegistroHabito;
import com.example.demo.model.Usuario;
import com.example.demo.service.HabitoService;
import com.example.demo.service.RegistroHabitoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private HabitoService habitoService;

    @Autowired
    private RegistroHabitoService registroHabitoService;

    // Página de inicio
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Página de gestión de usuarios
    @GetMapping("/page/usuarios")
    public String pageUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    // Página de gestión de hábitos
    @GetMapping("/page/habitos")
    public String pageHabitos(Model model) {
        List<Habito> habitos = habitoService.getAllHabitos();
        model.addAttribute("habitos", habitos);
        return "habitos";
    }

    // Página de registros de hábitos
    @GetMapping("/page/registros")
    public String pageRegistros(Model model) {
        List<RegistroHabito> registros = registroHabitoService.getAllRegistros();
        model.addAttribute("registros", registros);
        return "registros";
    }

    // Registrar un hábito
    @PostMapping("/registrar-habito")
    public String registrarHabito(@RequestParam Long usuarioId, @RequestParam Long habitoId) {
        Usuario usuario = usuarioService.getUsuarioById(usuarioId).orElse(null);
        Habito habito = habitoService.getHabitoById(habitoId).orElse(null);

        if (usuario != null && habito != null) {
            RegistroHabito registro = new RegistroHabito(usuario, habito, LocalDate.now());
            registroHabitoService.saveRegistro(registro);
        }

        return "redirect:/page/registros";
    }
}
