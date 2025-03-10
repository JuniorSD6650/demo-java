package com.example.demo.controller;

import com.example.demo.model.Habito;
import com.example.demo.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    @Autowired
    private HabitoService habitoService;

    @GetMapping
    public List<Habito> getAllHabitos() {
        return habitoService.getAllHabitos();
    }

    @GetMapping("/{id}")
    public Optional<Habito> getHabitoById(@PathVariable Long id) {
        return habitoService.getHabitoById(id);
    }

    @PostMapping
    public Habito createHabito(@RequestBody Habito habito) {
        return habitoService.saveHabito(habito);
    }

    @PutMapping("/{id}")
    public Habito updateHabito(@PathVariable Long id, @RequestBody Habito habito) {
        habito.setId(id);
        return habitoService.saveHabito(habito);
    }

    @DeleteMapping("/{id}")
    public void deleteHabito(@PathVariable Long id) {
        habitoService.deleteHabito(id);
    }
}
