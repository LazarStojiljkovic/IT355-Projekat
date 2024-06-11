package com.movies.IT355_Projekat.controller;

import com.movies.IT355_Projekat.entity.Direktor;
import com.movies.IT355_Projekat.service.DirektorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/direktor")
@RequiredArgsConstructor
public class DirektorController {

    private final DirektorService direktorService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Direktor>> getAll(){
        return ResponseEntity.ok(direktorService.findAll());
    }
    @GetMapping("/{direktor_id}")
    public ResponseEntity<Direktor> getById(@PathVariable Integer direktor_id){
        return ResponseEntity.ok(direktorService.findById(direktor_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<Direktor> create(@RequestBody Direktor direktor){
        return ResponseEntity.ok(direktorService.create(direktor));
    }

    @PutMapping("/update")
    public ResponseEntity<Direktor> update(@RequestBody Direktor direktor){
        return ResponseEntity.ok(direktorService.update(direktor));
    }

    @DeleteMapping("/{direktor_id}")
    public ResponseEntity<Direktor> deleteById(@PathVariable Integer direktor_id){
        direktorService.deleteById(direktor_id);
        return ResponseEntity.ok().build();
    }


}
