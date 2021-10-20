/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBarcos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioBoat {
    
    @Autowired
    private InterfaceBoat crud;

    public List<Boats> getAll(){
        return (List<Boats>) crud.findAll();
    }

    public Optional<Boats> getBoats(int id){
        return crud.findById(id);
    }

    public Boats save(Boats boats){
        return crud.save(boats);
    }
    public void delete(Boats boats){
        crud.delete(boats);
    }
    
}
