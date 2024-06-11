package com.movies.IT355_Projekat.repositorty;

import com.movies.IT355_Projekat.entity.Glumac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlumacRepository extends JpaRepository<Glumac, Integer> {
}