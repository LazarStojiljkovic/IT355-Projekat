package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.GlumacFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlumacFilmRepository extends JpaRepository<GlumacFilm, Integer> {
}