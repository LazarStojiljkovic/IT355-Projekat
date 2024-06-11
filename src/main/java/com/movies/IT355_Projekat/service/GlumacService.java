package com.movies.IT355_Projekat.service;

import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.entity.Glumac;

import java.util.List;
import java.util.Optional;

public interface GlumacService {

    List<Glumac> findAll();
    Optional<Glumac> findById(Integer gluma_id);
    Glumac create(Glumac glumac);
    Glumac update(Glumac glumac);
    void deleteById(Integer glumac_id);
}
