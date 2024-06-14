package com.example.teste.controllers;

import com.example.teste.models.EventosModels;
import com.example.teste.models.LocaisModels;
import com.example.teste.repositories.EventosRepository;
import com.example.teste.repositories.LocaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locais")
public class LocaisController {

    @Autowired
    private LocaisRepository repository;

    public LocaisController(LocaisRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<LocaisModels>> getLocais() {

        var locais = this.repository.getLocais();
        return ResponseEntity.status(HttpStatus.OK).body(locais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocaisModels> getLocais(@PathVariable("id") int id) {
        var local = this.repository.getLocais(id);
        if (local == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(local);
    }

    @PostMapping
    public ResponseEntity<LocaisModels> addClientes(@RequestBody LocaisModels local) {
        this.repository.addLocais(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(local);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCliente(@PathVariable("id") int id, @RequestBody LocaisModels local) {
        var result = this.repository.updateLocais(id, local);
        if (result) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLocais(@PathVariable("id") int id) {
        var result = this.repository.deleteLocais(id);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
