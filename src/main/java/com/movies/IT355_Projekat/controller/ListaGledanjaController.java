package com.movies.IT355_Projekat.controller;

import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.service.ListaGledanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/listaGledanja")
@RequiredArgsConstructor
public class ListaGledanjaController {
    
    private  final ListaGledanjaService listaGledanjaService;


    @GetMapping("/getAll")
    public ResponseEntity<List<ListaGledanja>> getAll(){
        return ResponseEntity.ok(listaGledanjaService.findAll());
    }
    @GetMapping("/{listaGledanja_id}")
    public ResponseEntity<ListaGledanja> getById(@PathVariable Integer listaGledanja_id){
        return ResponseEntity.ok(listaGledanjaService.findById(listaGledanja_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<ListaGledanja> create(@RequestBody ListaGledanja listaGledanja){
        return ResponseEntity.ok(listaGledanjaService.create(listaGledanja));
    }

    @PutMapping("/update")
    public ResponseEntity<ListaGledanja> update(@RequestBody ListaGledanja listaGledanja){
        return ResponseEntity.ok(listaGledanjaService.update(listaGledanja));
    }

    @DeleteMapping("/{listaGledanja_id}")
    public ResponseEntity<ListaGledanja> deleteById(@PathVariable Integer listaGledanja_id){
        listaGledanjaService.deleteById(listaGledanja_id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findByKorisnik_Id/{korisnik_id}")
    public ResponseEntity<ListaGledanja> findByKorisnik_Id(@PathVariable Integer korisnik_id){
        return ResponseEntity.ok(listaGledanjaService.findByKorisnik_Id(korisnik_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartNotFound")));
    }
    
}
