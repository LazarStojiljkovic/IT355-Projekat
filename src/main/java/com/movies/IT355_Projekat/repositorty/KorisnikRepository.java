package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    @Query("select k from Korisnik k where k.email = ?1")
    Optional<Korisnik>  findByEmail(String email);

    @Query("select k from Korisnik k where k.email = ?1 and k.sifra = ?2")
    Optional<Korisnik> findByEmailAndSifra(String email, String sifra);


}