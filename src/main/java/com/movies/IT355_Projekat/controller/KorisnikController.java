package com.movies.IT355_Projekat.controller;

import com.movies.IT355_Projekat.entity.Korisnik;
import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.service.KorisnikService;
import com.movies.IT355_Projekat.service.ListaGledanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/korisnik")
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikService korisnikService;
    private final ListaGledanjaService listaGledanjaService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Korisnik>> getAll(){
        return ResponseEntity.ok(korisnikService.findAll());
    }
    @GetMapping("/{korisnik_id}")
    public ResponseEntity<Korisnik> getById(@PathVariable Integer korisnik_id){
        return ResponseEntity.ok(korisnikService.findById(korisnik_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countryNotFound")));
    }

    @PostMapping("/create")
    public ResponseEntity<Korisnik> create(@RequestBody Korisnik korisnik){

        Korisnik sacuvaniKorisnik = korisnikService.create(korisnik);
        ListaGledanja listaGledanja = new ListaGledanja();
        listaGledanja.setKorisnik(sacuvaniKorisnik);
        listaGledanjaService.create(listaGledanja);
        return ResponseEntity.ok(sacuvaniKorisnik);


    }

    @PutMapping("/update")
    public ResponseEntity<Korisnik> update(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(korisnikService.update(korisnik));
    }

    @DeleteMapping("/{korisnik_id}")
    public ResponseEntity<Korisnik> deleteById(@PathVariable Integer korisnik_id){
        korisnikService.deleteById(korisnik_id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Korisnik korisnik) {
        return korisnikService.login(korisnik.getEmail(), korisnik.getSifra());
    }
    @GetMapping("/proveraEmail")
    public ResponseEntity<Boolean> proveraEmail(@RequestParam String email) {
        boolean exists = korisnikService.emailPostoji(email);
        return ResponseEntity.ok(exists);
    }


}
