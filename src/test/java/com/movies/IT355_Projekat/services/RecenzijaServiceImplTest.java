package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.Recenzija;
import com.movies.IT355_Projekat.repositorty.RecenzijaRepository;
import com.movies.IT355_Projekat.service.implementation.RecenzijaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecenzijaServiceImplTest {

    @Mock
    private RecenzijaRepository recenzijaRepository;

    @InjectMocks
    private RecenzijaServiceImpl recenzijaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Recenzija> recenzijas = Arrays.asList(new Recenzija(), new Recenzija());
        when(recenzijaRepository.findAll()).thenReturn(recenzijas);

        List<Recenzija> result = recenzijaService.findAll();

        assertEquals(recenzijas, result);
        verify(recenzijaRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Recenzija recenzija = new Recenzija();
        when(recenzijaRepository.findById(id)).thenReturn(Optional.of(recenzija));

        Optional<Recenzija> result = recenzijaService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(recenzija, result.get());
        verify(recenzijaRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(recenzijaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Recenzija> result = recenzijaService.findById(id);

        assertFalse(result.isPresent());
        verify(recenzijaRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        Recenzija recenzija = new Recenzija();
        when(recenzijaRepository.save(recenzija)).thenReturn(recenzija);

        Recenzija result = recenzijaService.create(recenzija);

        assertEquals(recenzija, result);
        verify(recenzijaRepository, times(1)).save(recenzija);
    }

    @Test
    public void testUpdate() {
        Recenzija recenzija = new Recenzija();
        when(recenzijaRepository.save(recenzija)).thenReturn(recenzija);

        Recenzija result = recenzijaService.update(recenzija);

        assertEquals(recenzija, result);
        verify(recenzijaRepository, times(1)).save(recenzija);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(recenzijaRepository).deleteById(id);

        recenzijaService.deleteById(id);

        verify(recenzijaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByFilmId() {
        int filmId = 1;
        List<Recenzija> recenzijas = Arrays.asList(new Recenzija(), new Recenzija());
        when(recenzijaRepository.findByFilmId(filmId)).thenReturn(recenzijas);

        List<Recenzija> result = recenzijaService.findByFilmId(filmId);

        assertEquals(recenzijas, result);
        verify(recenzijaRepository, times(1)).findByFilmId(filmId);
    }
}
