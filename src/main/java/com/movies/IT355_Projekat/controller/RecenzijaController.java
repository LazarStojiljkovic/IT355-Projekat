package com.movies.IT355_Projekat.controller;

import com.movies.IT355_Projekat.entity.Recenzija;
import com.movies.IT355_Projekat.service.RecenzijaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/recenzija")
@RequiredArgsConstructor
public class RecenzijaController {

    private  final RecenzijaService recenzijaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Recenzija>> getAll(){
        return ResponseEntity.ok(recenzijaService.findAll());
    }
    @GetMapping("/{recenzija_id}")
    public ResponseEntity<Recenzija> getById(@PathVariable Integer recenzija_id){
        return ResponseEntity.ok(recenzijaService.findById(recenzija_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<Recenzija> create(@RequestBody Recenzija recenzija){
        return ResponseEntity.ok(recenzijaService.create(recenzija));
    }

    @PutMapping("/update")
    public ResponseEntity<Recenzija> update(@RequestBody Recenzija recenzija){
        return ResponseEntity.ok(recenzijaService.update(recenzija));
    }

    @DeleteMapping("/{recenzija_id}")
    public ResponseEntity<Recenzija> deleteById(@PathVariable Integer recenzija_id){
        recenzijaService.deleteById(recenzija_id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getByFilmId/{filmId}")
    public ResponseEntity<List<Recenzija>> getByFilmId(@PathVariable Integer filmId){
        return ResponseEntity.ok(recenzijaService.findByFilmId(filmId));
    }
}
