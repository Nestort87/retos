/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBarcos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorBoat {
     @Autowired
    private ServiciosBoat servicio;
    @GetMapping("/all")
    public List<Boats> getBoat(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boats> getBoats(@PathVariable("id") int boatsId) {
        return servicio.getBoats(boatsId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boats save(@RequestBody Boats boats) {
        return servicio.save(boats);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boats update(@RequestBody Boats boats) {
        return servicio.update(boats);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boatsId) {
        return servicio.deleteBoats(boatsId);
    } 
}
