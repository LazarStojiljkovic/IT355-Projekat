package com.movies.IT355_Projekat.controller;


import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.service.FilmService;
import com.movies.IT355_Projekat.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmController {



    private final FilmService filmService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Film>> getAll(){
        return ResponseEntity.ok(filmService.findAll());
    }
    @GetMapping("/{film_id}")
    public ResponseEntity<Film> getById(@PathVariable Integer film_id){
        return ResponseEntity.ok(filmService.findById(film_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film film){
        return ResponseEntity.ok(filmService.create(film));
    }

    @PutMapping("/update")
    public ResponseEntity<Film> update(@RequestBody Film film){
        return ResponseEntity.ok(filmService.update(film));
    }

    @DeleteMapping("/{film_id}")
    public ResponseEntity<Film> deleteById(@PathVariable Integer film_id){
        filmService.deleteById(film_id);
        return ResponseEntity.ok().build();
    }

}
