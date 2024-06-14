package com.example.teste.repositories;

import com.example.teste.models.EventosModels;
import com.example.teste.repositories.interfaces.IEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventosRepository {

    @Autowired
    private IEventos iEventos;

    public List<EventosModels> getEventos(){
        return iEventos.findAll();
    }

    public EventosModels getEventos(int id){
        return iEventos.findById(id).get();
    }

    public EventosModels addEventos(EventosModels evento){
        iEventos.save(evento);
        return evento;
    }

    public boolean updateEventos(int id, EventosModels evento){
        var eventosExistente = iEventos.findById(id).get();
        if(eventosExistente == null){
            return false;
        }

        eventosExistente.setEvento(evento.getEvento());
        eventosExistente.setEstadio(evento.getEstadio());

        try{
            iEventos.save(eventosExistente);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean deleteEventos(int id){
        var evento = iEventos.findById(id).get();
        if(evento == null){
            return false;
        }
        iEventos.delete(evento);
        return true;
    }
}
