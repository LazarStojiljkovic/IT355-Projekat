package com.movies.IT355_Projekat.controller;


import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;
import com.movies.IT355_Projekat.service.ListaGledanjaFilmService;
import com.movies.IT355_Projekat.service.ListaGledanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/listaGledanjaFilm")
@RequiredArgsConstructor
public class ListaGledanjaFIlmController {


    private  final ListaGledanjaFilmService listaGledanjaFilmService;


    @GetMapping("/getAll")
    public ResponseEntity<List<ListaGledanjaFilm>> getAll(){
        return ResponseEntity.ok(listaGledanjaFilmService.findAll());
    }
    @GetMapping("/{listaGledanja_id}")
    public ResponseEntity<ListaGledanjaFilm> getById(@PathVariable Integer listaGledanjaFilm_id){
        return ResponseEntity.ok(listaGledanjaFilmService.findById(listaGledanjaFilm_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<ListaGledanjaFilm> create(@RequestBody ListaGledanjaFilm listaGledanjaFilm){
        return ResponseEntity.ok(listaGledanjaFilmService.create(listaGledanjaFilm));
    }

    @PutMapping("/update")
    public ResponseEntity<ListaGledanjaFilm> update(@RequestBody ListaGledanjaFilm listaGledanjaFilm){
        return ResponseEntity.ok(listaGledanjaFilmService.update(listaGledanjaFilm));
    }

    @DeleteMapping("/{listaGledanjaFilm_id}")
    public ResponseEntity<ListaGledanjaFilm> deleteById(@PathVariable Integer listaGledanjaFilm_id){
        listaGledanjaFilmService.deleteById(listaGledanjaFilm_id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listaGledanja/{id}")
    public ResponseEntity<List<ListaGledanjaFilm>> getByListaGledanjaId(@PathVariable Integer id) {
        return ResponseEntity.ok(listaGledanjaFilmService.getByListaGledanjaId(id));
    }
    @GetMapping("/findByListaGledanja_Korisnik_Id/{korisnik_id}")
    public  ResponseEntity<List<ListaGledanjaFilm>>findByListaGledanja_Korisnik_Id(@PathVariable Integer korisnik_id){
        return   ResponseEntity.ok(listaGledanjaFilmService.findByListaGledanja_Korisnik_Id(korisnik_id));
    }
    @DeleteMapping("/deleteByListaGledanja_Korisnik_Id/{korisnik_id}")
    public ResponseEntity<Void> deleteByListaGledanja_Korisnik_Id(@PathVariable Integer korisnik_id) {
        listaGledanjaFilmService.deleteByListaGledanja_Korisnik_Id(korisnik_id);
        return ResponseEntity.ok().build();
    }
}
