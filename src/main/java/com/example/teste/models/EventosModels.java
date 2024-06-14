package com.example.teste.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "eventos")
public class EventosModels {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 100) @NotNull @NotEmpty String getEvento() {
        return evento;
    }

    public void setEvento(@Size(max = 100) @NotNull @NotEmpty String evento) {
        this.evento = evento;
    }

    public @Size(max = 100) @NotNull String getEstadio() {
        return estadio;
    }

    public void setEstadio(@Size(max = 100) @NotNull String estadio) {
        this.estadio = estadio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String evento;

    @Size(max = 100)
    @NotNull
    private String estadio;

}
