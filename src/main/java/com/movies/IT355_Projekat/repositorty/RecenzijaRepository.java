package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Integer> {
   @Query("select r from Recenzija r where r.film.id = ?1")
    List<Recenzija> findByFilmId(Integer id);



}