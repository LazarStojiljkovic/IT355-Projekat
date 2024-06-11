package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.ListaGledanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ListaGledanjaRepository extends JpaRepository<ListaGledanja, Integer> {
    @Query("select l from ListaGledanja l where l.korisnik.id = ?1")
    Optional<ListaGledanja> findByKorisnik_Id(Integer id);
}