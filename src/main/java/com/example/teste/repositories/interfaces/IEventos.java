package com.example.teste.repositories.interfaces;

import com.example.teste.models.EventosModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventos extends JpaRepository<EventosModels, Integer> {

}
