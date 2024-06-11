package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.Film;
import com.movies.IT355_Projekat.repositorty.FilmRepository;
import com.movies.IT355_Projekat.service.FilmService;
import com.movies.IT355_Projekat.service.implementation.FilmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilmServiceImplTest {

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmServiceImpl filmService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Film> films = Arrays.asList(new Film(), new Film());
        when(filmRepository.findAll()).thenReturn(films);

        List<Film> result = filmService.findAll();

        assertEquals(films, result);
        verify(filmRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Film film = new Film();
        when(filmRepository.findById(id)).thenReturn(Optional.of(film));

        Optional<Film> result = filmService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(film, result.get());
        verify(filmRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(filmRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Film> result = filmService.findById(id);

        assertFalse(result.isPresent());
        verify(filmRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        Film film = new Film();
        when(filmRepository.save(film)).thenReturn(film);

        Film result = filmService.create(film);

        assertEquals(film, result);
        verify(filmRepository, times(1)).save(film);
    }

    @Test
    public void testUpdate() {
        Film film = new Film();
        when(filmRepository.save(film)).thenReturn(film);

        Film result = filmService.update(film);

        assertEquals(film, result);
        verify(filmRepository, times(1)).save(film);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(filmRepository).deleteById(id);

        filmService.deleteById(id);

        verify(filmRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(filmRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> filmService.deleteById(id));
        verify(filmRepository, times(1)).deleteById(id);
    }
}