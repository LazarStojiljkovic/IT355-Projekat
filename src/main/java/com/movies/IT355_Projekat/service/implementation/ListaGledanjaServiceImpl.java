package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.repositorty.ListaGledanjaRepository;
import com.movies.IT355_Projekat.service.ListaGledanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaGledanjaServiceImpl implements ListaGledanjaService {

    private final ListaGledanjaRepository listaGledanjaRepository;


    @Override
    public List<ListaGledanja> findAll() {
        return listaGledanjaRepository.findAll();
    }

    @Override
    public Optional<ListaGledanja> findById(Integer listaGledanja_id) {
        return listaGledanjaRepository.findById(listaGledanja_id);
    }

    @Override
    public ListaGledanja create(ListaGledanja listaGledanja) {
        return listaGledanjaRepository.save(listaGledanja);
    }

    @Override
    public ListaGledanja update(ListaGledanja listaGledanja) {
        return listaGledanjaRepository.save(listaGledanja);
    }

    @Override
    public void deleteById(Integer listaGledanja_id) {
        listaGledanjaRepository.deleteById(listaGledanja_id);

    }

    @Override
    public Optional<ListaGledanja> findByKorisnik_Id(Integer korisnik_id) {
        return listaGledanjaRepository.findByKorisnik_Id(korisnik_id);
    }
}
