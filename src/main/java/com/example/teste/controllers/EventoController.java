package com.example.teste.controllers;

import com.example.teste.models.EventosModels;
import com.example.teste.repositories.EventosRepository;
import com.example.teste.repositories.interfaces.IEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eventos")
public class EventoController {

    @Autowired
    private EventosRepository repository;

    public EventoController(EventosRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<EventosModels>>getEventos(){

        var eventos = this.repository.getEventos();
        return ResponseEntity.status(HttpStatus.OK).body(eventos);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventosModels> getEventos(@PathVariable("id") int id){
        var evento = this.repository.getEventos(id);
        if(evento == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @PostMapping
    public ResponseEntity<EventosModels> addClientes(@RequestBody EventosModels evento){
        this.repository.addEventos(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCliente(@PathVariable("id") int id, @RequestBody EventosModels evento){
        var result = this.repository.updateEventos(id, evento);
        if(result){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEventos(@PathVariable("id")int id){
        var result = this.repository.deleteEventos(id);
        if(!result){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
