package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.Direktor;
import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.repositorty.DirektorRepository;
import com.movies.IT355_Projekat.service.DirektorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirektorServiceImpl implements DirektorService {

    private final DirektorRepository direktorRepository;

    @Override
    public List<Direktor> findAll() {
        return direktorRepository.findAll();
    }

    @Override
    public Optional<Direktor> findById(Integer direktor_id) {
        return direktorRepository.findById(direktor_id);
    }

    @Override
    public Direktor create(Direktor direktor) {
        return direktorRepository.save(direktor);
    }

    @Override
    public Direktor update(Direktor direktor) {
        return direktorRepository.save(direktor);
    }

    @Override
    public void deleteById(Integer direktor_id) {
        direktorRepository.deleteById(direktor_id);

    }
}
