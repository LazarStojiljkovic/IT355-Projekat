package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.ListaGledanjaFilm;
import com.movies.IT355_Projekat.repositorty.ListaGledanjaFilmRepository;
import com.movies.IT355_Projekat.service.implementation.ListaGledanjaFilmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListaGledanjaFilmServiceImplTest {

    @Mock
    private ListaGledanjaFilmRepository listaGledanjaFilmRepository;

    @InjectMocks
    private ListaGledanjaFilmServiceImpl listaGledanjaFilmService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<ListaGledanjaFilm> listaGledanjaFilms = Arrays.asList(new ListaGledanjaFilm(), new ListaGledanjaFilm());
        when(listaGledanjaFilmRepository.findAll()).thenReturn(listaGledanjaFilms);

        List<ListaGledanjaFilm> result = listaGledanjaFilmService.findAll();

        assertEquals(listaGledanjaFilms, result);
        verify(listaGledanjaFilmRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        ListaGledanjaFilm listaGledanjaFilm = new ListaGledanjaFilm();
        when(listaGledanjaFilmRepository.findById(id)).thenReturn(Optional.of(listaGledanjaFilm));

        Optional<ListaGledanjaFilm> result = listaGledanjaFilmService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(listaGledanjaFilm, result.get());
        verify(listaGledanjaFilmRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(listaGledanjaFilmRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ListaGledanjaFilm> result = listaGledanjaFilmService.findById(id);

        assertFalse(result.isPresent());
        verify(listaGledanjaFilmRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        ListaGledanjaFilm listaGledanjaFilm = new ListaGledanjaFilm();
        when(listaGledanjaFilmRepository.save(listaGledanjaFilm)).thenReturn(listaGledanjaFilm);

        ListaGledanjaFilm result = listaGledanjaFilmService.create(listaGledanjaFilm);

        assertEquals(listaGledanjaFilm, result);
        verify(listaGledanjaFilmRepository, times(1)).save(listaGledanjaFilm);
    }

    @Test
    public void testUpdate() {
        ListaGledanjaFilm listaGledanjaFilm = new ListaGledanjaFilm();
        when(listaGledanjaFilmRepository.save(listaGledanjaFilm)).thenReturn(listaGledanjaFilm);

        ListaGledanjaFilm result = listaGledanjaFilmService.update(listaGledanjaFilm);

        assertEquals(listaGledanjaFilm, result);
        verify(listaGledanjaFilmRepository, times(1)).save(listaGledanjaFilm);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(listaGledanjaFilmRepository).deleteById(id);

        listaGledanjaFilmService.deleteById(id);

        verify(listaGledanjaFilmRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetByListaGledanjaId() {
        int listaGledanjaId = 1;
        List<ListaGledanjaFilm> listaGledanjaFilms = Arrays.asList(new ListaGledanjaFilm(), new ListaGledanjaFilm());
        when(listaGledanjaFilmRepository.findByListaGledanjaId(listaGledanjaId)).thenReturn(listaGledanjaFilms);

        List<ListaGledanjaFilm> result = listaGledanjaFilmService.getByListaGledanjaId(listaGledanjaId);

        assertEquals(listaGledanjaFilms, result);
        verify(listaGledanjaFilmRepository, times(1)).findByListaGledanjaId(listaGledanjaId);
    }

    @Test
    public void testFindByListaGledanjaKorisnikId() {
        int korisnikId = 1;
        List<ListaGledanjaFilm> listaGledanjaFilms = Arrays.asList(new ListaGledanjaFilm(), new ListaGledanjaFilm());
        when(listaGledanjaFilmRepository.findByListaGledanja_Korisnik_Id(korisnikId)).thenReturn(listaGledanjaFilms);

        List<ListaGledanjaFilm> result = listaGledanjaFilmService.findByListaGledanja_Korisnik_Id(korisnikId);

        assertEquals(listaGledanjaFilms, result);
        verify(listaGledanjaFilmRepository, times(1)).findByListaGledanja_Korisnik_Id(korisnikId);
    }

    @Test
    public void testDeleteByListaGledanjaKorisnikId() {
        int korisnikId = 1;

        doNothing().when(listaGledanjaFilmRepository).deleteByListaGledanja_Korisnik_Id(korisnikId);

        listaGledanjaFilmService.deleteByListaGledanja_Korisnik_Id(korisnikId);

        verify(listaGledanjaFilmRepository, times(1)).deleteByListaGledanja_Korisnik_Id(korisnikId);
    }
}
