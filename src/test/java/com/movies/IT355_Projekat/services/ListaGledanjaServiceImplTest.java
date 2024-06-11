package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.ListaGledanja;
import com.movies.IT355_Projekat.repositorty.ListaGledanjaRepository;
import com.movies.IT355_Projekat.service.implementation.ListaGledanjaServiceImpl;
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

public class ListaGledanjaServiceImplTest {

    @Mock
    private ListaGledanjaRepository listaGledanjaRepository;

    @InjectMocks
    private ListaGledanjaServiceImpl listaGledanjaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<ListaGledanja> listaGledanjas = Arrays.asList(new ListaGledanja(), new ListaGledanja());
        when(listaGledanjaRepository.findAll()).thenReturn(listaGledanjas);

        List<ListaGledanja> result = listaGledanjaService.findAll();

        assertEquals(listaGledanjas, result);
        verify(listaGledanjaRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        ListaGledanja listaGledanja = new ListaGledanja();
        when(listaGledanjaRepository.findById(id)).thenReturn(Optional.of(listaGledanja));

        Optional<ListaGledanja> result = listaGledanjaService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(listaGledanja, result.get());
        verify(listaGledanjaRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(listaGledanjaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ListaGledanja> result = listaGledanjaService.findById(id);

        assertFalse(result.isPresent());
        verify(listaGledanjaRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        ListaGledanja listaGledanja = new ListaGledanja();
        when(listaGledanjaRepository.save(listaGledanja)).thenReturn(listaGledanja);

        ListaGledanja result = listaGledanjaService.create(listaGledanja);

        assertEquals(listaGledanja, result);
        verify(listaGledanjaRepository, times(1)).save(listaGledanja);
    }

    @Test
    public void testUpdate() {
        ListaGledanja listaGledanja = new ListaGledanja();
        when(listaGledanjaRepository.save(listaGledanja)).thenReturn(listaGledanja);

        ListaGledanja result = listaGledanjaService.update(listaGledanja);

        assertEquals(listaGledanja, result);
        verify(listaGledanjaRepository, times(1)).save(listaGledanja);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(listaGledanjaRepository).deleteById(id);

        listaGledanjaService.deleteById(id);

        verify(listaGledanjaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByKorisnikId() {
        int korisnikId = 1;
        ListaGledanja listaGledanja = new ListaGledanja();
        when(listaGledanjaRepository.findByKorisnik_Id(korisnikId)).thenReturn(Optional.of(listaGledanja));

        Optional<ListaGledanja> result = listaGledanjaService.findByKorisnik_Id(korisnikId);

        assertTrue(result.isPresent());
        assertEquals(listaGledanja, result.get());
        verify(listaGledanjaRepository, times(1)).findByKorisnik_Id(korisnikId);
    }
}
