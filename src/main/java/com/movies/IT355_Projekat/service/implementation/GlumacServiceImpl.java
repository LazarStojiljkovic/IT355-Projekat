package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.Glumac;
import com.movies.IT355_Projekat.repositorty.GlumacRepository;
import com.movies.IT355_Projekat.service.GlumacService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GlumacServiceImpl implements GlumacService {


    private final  GlumacRepository glumacRepository;

    @Override
    public List<Glumac> findAll() {
        return glumacRepository.findAll();
    }

    @Override
    public Optional<Glumac> findById(Integer gluma_id) {
        return glumacRepository.findById(gluma_id);
    }

    @Override
    public Glumac create(Glumac glumac) {
        return glumacRepository.save(glumac);
    }

    @Override
    public Glumac update(Glumac glumac) {
        return glumacRepository.save(glumac);
    }

    @Override
    public void deleteById(Integer glumac_id) {
        glumacRepository.deleteById(glumac_id);

    }
}
