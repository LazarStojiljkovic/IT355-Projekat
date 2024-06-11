package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;
import com.movies.IT355_Projekat.repositorty.ListaGledanjaFilmRepository;
import com.movies.IT355_Projekat.repositorty.ListaGledanjaRepository;
import com.movies.IT355_Projekat.service.ListaGledanjaFilmService;
import com.movies.IT355_Projekat.service.ListaGledanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaGledanjaFilmServiceImpl implements ListaGledanjaFilmService {


    private final ListaGledanjaFilmRepository listaGledanjaFilmRepository;


    @Override
    public List<ListaGledanjaFilm> findAll() {
        return listaGledanjaFilmRepository.findAll();
    }

    @Override
    public Optional<ListaGledanjaFilm> findById(Integer listaGledanja_id) {
        return listaGledanjaFilmRepository.findById(listaGledanja_id);
    }



    @Override
    public ListaGledanjaFilm create(ListaGledanjaFilm listaGledanjaFilm) {
        listaGledanjaFilm.setDatumDodavanja(LocalDate.now());
        return listaGledanjaFilmRepository.save(listaGledanjaFilm);
    }

    @Override
    public ListaGledanjaFilm update(ListaGledanjaFilm listaGledanjaFilm) {
        return listaGledanjaFilmRepository.save(listaGledanjaFilm);
    }

    @Override
    public void deleteById(Integer listaGledanjaFilm_id) {
        listaGledanjaFilmRepository.deleteById(listaGledanjaFilm_id);

    }

    @Override
    public List<ListaGledanjaFilm> getByListaGledanjaId(Integer listaGledanjaId) {
        return listaGledanjaFilmRepository.findByListaGledanjaId(listaGledanjaId);
    }

    @Override
    public List<ListaGledanjaFilm> findByListaGledanja_Korisnik_Id(Integer korisnik_id) {
        return listaGledanjaFilmRepository.findByListaGledanja_Korisnik_Id(korisnik_id);
    }

    @Override
    public void deleteByListaGledanja_Korisnik_Id(Integer korisnik_id) {
        listaGledanjaFilmRepository.deleteByListaGledanja_Korisnik_Id(korisnik_id);

    }
}
