package com.example.teste.repositories;

import com.example.teste.models.EventosModels;
import com.example.teste.models.LocaisModels;
import com.example.teste.repositories.interfaces.ILocais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocaisRepository {

    @Autowired
    private ILocais iLocais;

    public List<LocaisModels> getLocais(){
        return iLocais.findAll();
    }

    public LocaisModels getLocais(int id){
        return iLocais.findById(id).get();
    }

    public LocaisModels addLocais(LocaisModels local){
        iLocais.save(local);
        return local;
    }

    public boolean updateLocais(int id, LocaisModels local){

        var locaisExistentes = iLocais.findById(id).get();

        if(locaisExistentes == null){
            return false;
        }

        locaisExistentes.setBairro(local.getBairro());
        locaisExistentes.setEmail(local.getEmail());
        locaisExistentes.setEndereco(local.getEndereco());

        try{
            iLocais.save(locaisExistentes);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean deleteLocais(int id){
        var local = iLocais.findById(id).get();
        if(local == null){
            return false;
        }
        iLocais.delete(local);
        return true;
    }

}
