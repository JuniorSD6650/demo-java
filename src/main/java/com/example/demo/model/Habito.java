package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Habito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private String frecuencia; // Diario, Semanal, Mensual

    @OneToMany(mappedBy = "habito", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroHabito> registros;

    public Habito() {}

    public Habito(String nombre, String frecuencia) {
        this.nombre = nombre;
        this.frecuencia = frecuencia;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFrecuencia() { return frecuencia; }
    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }

    public List<RegistroHabito> getRegistros() { return registros; }
    public void setRegistros(List<RegistroHabito> registros) { this.registros = registros; }
}
