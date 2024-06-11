package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.Direktor;
import com.movies.IT355_Projekat.repositorty.DirektorRepository;
import com.movies.IT355_Projekat.service.implementation.DirektorServiceImpl;
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

public class DirektorServiceImplTest {

    @Mock
    private DirektorRepository direktorRepository;

    @InjectMocks
    private DirektorServiceImpl direktorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Direktor> direktors = Arrays.asList(new Direktor(), new Direktor());
        when(direktorRepository.findAll()).thenReturn(direktors);

        List<Direktor> result = direktorService.findAll();

        assertEquals(direktors, result);
        verify(direktorRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Direktor direktor = new Direktor();
        when(direktorRepository.findById(id)).thenReturn(Optional.of(direktor));

        Optional<Direktor> result = direktorService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(direktor, result.get());
        verify(direktorRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(direktorRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Direktor> result = direktorService.findById(id);

        assertFalse(result.isPresent());
        verify(direktorRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        Direktor direktor = new Direktor();
        when(direktorRepository.save(direktor)).thenReturn(direktor);

        Direktor result = direktorService.create(direktor);

        assertEquals(direktor, result);
        verify(direktorRepository, times(1)).save(direktor);
    }

    @Test
    public void testUpdate() {
        Direktor direktor = new Direktor();
        when(direktorRepository.save(direktor)).thenReturn(direktor);

        Direktor result = direktorService.update(direktor);

        assertEquals(direktor, result);
        verify(direktorRepository, times(1)).save(direktor);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(direktorRepository).deleteById(id);

        direktorService.deleteById(id);

        verify(direktorRepository, times(1)).deleteById(id);
    }
}
