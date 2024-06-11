package com.movies.IT355_Projekat.controller;

import com.movies.IT355_Projekat.entity.Glumac;
import com.movies.IT355_Projekat.service.GlumacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/glumac")
@RequiredArgsConstructor
public class GlumacController {

    private  final GlumacService glumacService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Glumac>> getAll(){
        return ResponseEntity.ok(glumacService.findAll());
    }
    @GetMapping("/{glumac_id}")
    public ResponseEntity<Glumac> getById(@PathVariable Integer glumac_id){
        return ResponseEntity.ok(glumacService.findById(glumac_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<Glumac> create(@RequestBody Glumac glumac){
        return ResponseEntity.ok(glumacService.create(glumac));
    }

    @PutMapping("/update")
    public ResponseEntity<Glumac> update(@RequestBody Glumac glumac){
        return ResponseEntity.ok(glumacService.update(glumac));
    }

    @DeleteMapping("/{glumac_id}")
    public ResponseEntity<Glumac> deleteById(@PathVariable Integer glumac_id){
        glumacService.deleteById(glumac_id);
        return ResponseEntity.ok().build();
    }
}
