package com.movies.IT355_Projekat.service.implementation;


import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.entity.Recenzija;
import com.movies.IT355_Projekat.repositorty.RecenzijaRepository;
import com.movies.IT355_Projekat.service.RecenzijaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecenzijaServiceImpl implements RecenzijaService {

    private final RecenzijaRepository recenzijaRepository;


    @Override
    public List<Recenzija> findAll() {
        return recenzijaRepository.findAll();
    }

    @Override
    public Optional<Recenzija> findById(Integer recenzija_id) {
        return recenzijaRepository.findById(recenzija_id);
    }

    @Override
    public Recenzija create(Recenzija recenzija) {
        return recenzijaRepository.save(recenzija);
    }

    @Override
    public Recenzija update(Recenzija recenzija) {
        return recenzijaRepository.save(recenzija);
    }

    @Override
    public void deleteById(Integer recenzija_id) {
        recenzijaRepository.deleteById(recenzija_id);

    }

    @Override
    public List<Recenzija> findByFilmId(Integer filmId) {
        return recenzijaRepository.findByFilmId(filmId);
    }
}
