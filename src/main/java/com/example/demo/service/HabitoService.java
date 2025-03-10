package com.example.demo.service;

import com.example.demo.model.Habito;
import com.example.demo.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    public List<Habito> getAllHabitos() {
        return habitoRepository.findAll();
    }

    public Optional<Habito> getHabitoById(Long id) {
        return habitoRepository.findById(id);
    }

    public Habito saveHabito(Habito habito) {
        return habitoRepository.save(habito);
    }

    public void deleteHabito(Long id) {
        habitoRepository.deleteById(id);
    }
}
