/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBarcos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosBoat {
     @Autowired
    private RepositorioBoat metodosCrud;

    public List<Boats> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boats> getBoats(int boatsId) {
        return metodosCrud.getBoats(boatsId);
    }

    public Boats save(Boats boats){
        if(boats.getId()==null){
            return metodosCrud.save(boats);
        }else{
            Optional<Boats> e=metodosCrud.getBoats(boats.getId());
            if(e.isEmpty()){
                return metodosCrud.save(boats);
            }else{
                return boats;
            }
        }
    }

    public Boats update(Boats boats){
        if(boats.getId()!=null){
            Optional<Boats> e=metodosCrud.getBoats(boats.getId());
            if(!e.isEmpty()){
                if(boats.getName()!=null){
                    e.get().setName(boats.getName());
                }
                if(boats.getBrand()!=null){
                    e.get().setBrand(boats.getBrand());
                }
                if(boats.getYear()!=null){
                    e.get().setYear(boats.getYear());
                }
                if(boats.getDescription()!=null){
                    e.get().setDescription(boats.getDescription());
                }
                if(boats.getCategory()!=null){
                    e.get().setCategory(boats.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return boats;
            }
        }else{
            return boats;
        }
    }


    public boolean deleteBoats(int boatsId) {
        Boolean aBoolean = getBoats(boatsId).map(boats -> {
            metodosCrud.delete(boats);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
