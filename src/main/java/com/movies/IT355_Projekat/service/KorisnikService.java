package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.Korisnik;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    List<Korisnik> findAll();
    Optional<Korisnik> findById(Integer korisnik_id);
    Korisnik create(Korisnik korisnik);
    Korisnik update(Korisnik korisnik);
    void deleteById(Integer korisnik_id);

    ResponseEntity<?> login(String email, String sifra);

    boolean emailPostoji(String email);




}
