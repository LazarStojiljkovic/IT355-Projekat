package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.Recenzija;

import java.util.List;
import java.util.Optional;

public interface RecenzijaService {
    List<Recenzija> findAll();
    Optional<Recenzija> findById(Integer recenzija_id);
    Recenzija create(Recenzija recenzija);
    Recenzija update(Recenzija recenzija);
    void deleteById(Integer recenzija_id);

    List<Recenzija> findByFilmId(Integer filmId);
}
