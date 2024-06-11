package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.Direktor;
import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.repositorty.DirektorRepository;
import com.movies.IT355_Projekat.repositorty.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DirektorService {




    List<Direktor> findAll();
    Optional<Direktor> findById(Integer direktor_id);
    Direktor create(Direktor direktor);
    Direktor update(Direktor direktor);
    void deleteById(Integer direktor_id);

}
