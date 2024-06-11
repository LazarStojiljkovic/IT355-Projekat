package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.Film;


import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> findAll();
    Optional<Film> findById(Integer film_id);
    Film create(Film film);
    Film update(Film film);
    void deleteById(Integer film_id);




}
