package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListaGledanjaFilmRepository extends JpaRepository<ListaGledanjaFilm, Integer> {
    @Query("select l from ListaGledanjaFilm l where l.listaGledanja.id = ?1")
    List<ListaGledanjaFilm> findByListaGledanjaId(Integer listaGledanjaId);

    @Query("select l from ListaGledanjaFilm l where l.listaGledanja.korisnik.id = ?1")
    List<ListaGledanjaFilm> findByListaGledanja_Korisnik_Id(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ListaGledanjaFilm lgf WHERE lgf.listaGledanja.id IN (SELECT lg.id FROM ListaGledanja lg WHERE lg.korisnik.id = ?1)")
    void deleteByListaGledanja_Korisnik_Id(Integer userId);


}