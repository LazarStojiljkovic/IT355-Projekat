package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.Glumac;
import com.movies.IT355_Projekat.repositorty.GlumacRepository;
import com.movies.IT355_Projekat.service.implementation.GlumacServiceImpl;
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

public class GlumacServiceImplTest {

    @Mock
    private GlumacRepository glumacRepository;

    @InjectMocks
    private GlumacServiceImpl glumacService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Glumac> glumci = Arrays.asList(new Glumac(), new Glumac());
        when(glumacRepository.findAll()).thenReturn(glumci);

        List<Glumac> result = glumacService.findAll();

        assertEquals(glumci, result);
        verify(glumacRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Glumac glumac = new Glumac();
        when(glumacRepository.findById(id)).thenReturn(Optional.of(glumac));

        Optional<Glumac> result = glumacService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(glumac, result.get());
        verify(glumacRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(glumacRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Glumac> result = glumacService.findById(id);

        assertFalse(result.isPresent());
        verify(glumacRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        Glumac glumac = new Glumac();
        when(glumacRepository.save(glumac)).thenReturn(glumac);

        Glumac result = glumacService.create(glumac);

        assertEquals(glumac, result);
        verify(glumacRepository, times(1)).save(glumac);
    }

    @Test
    public void testUpdate() {
        Glumac glumac = new Glumac();
        when(glumacRepository.save(glumac)).thenReturn(glumac);

        Glumac result = glumacService.update(glumac);

        assertEquals(glumac, result);
        verify(glumacRepository, times(1)).save(glumac);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(glumacRepository).deleteById(id);

        glumacService.deleteById(id);

        verify(glumacRepository, times(1)).deleteById(id);
    }
}
