package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.repositorty.FilmRepository;
import com.movies.IT355_Projekat.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<Film> findById(Integer film_id) {
        return filmRepository.findById(film_id);
    }

    @Override
    public Film create(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film update(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void deleteById(Integer film_id) {
        filmRepository.deleteById(film_id);

    }


}
