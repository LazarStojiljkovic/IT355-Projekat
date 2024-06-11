package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;

import java.util.List;
import java.util.Optional;

public interface ListaGledanjaService {

    List<ListaGledanja> findAll();
    Optional<ListaGledanja> findById(Integer listaGledanja_id);
    ListaGledanja create(ListaGledanja listaGledanja);
    ListaGledanja update(ListaGledanja listaGledanja);
    void deleteById(Integer listaGledanja_id);
    Optional<ListaGledanja>findByKorisnik_Id(Integer korisnik_id);


}
