package com.movies.IT355_Projekat.service;


import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;

import java.util.List;
import java.util.Optional;

public interface ListaGledanjaFilmService {

    List<ListaGledanjaFilm> findAll();
    Optional<ListaGledanjaFilm> findById(Integer listaGledanjaFilm_id);
    ListaGledanjaFilm create(ListaGledanjaFilm listaGledanjaFilm);
    ListaGledanjaFilm update(ListaGledanjaFilm listaGledanjaFilm);
    void deleteById(Integer listaGledanjaFilm_id);

    List<ListaGledanjaFilm>getByListaGledanjaId(Integer listaGledanjaId);

    List<ListaGledanjaFilm>findByListaGledanja_Korisnik_Id(Integer korisnik_id);

    void deleteByListaGledanja_Korisnik_Id(Integer korisnik_id);

}
