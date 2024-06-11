package com.movies.IT355_Projekat.services;

import com.movies.IT355_Projekat.entity.Korisnik;
import com.movies.IT355_Projekat.repositorty.KorisnikRepository;
import com.movies.IT355_Projekat.service.implementation.KorisnikServiceImpl;
import com.movies.IT355_Projekat.security.tools.JwtTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KorisnikServiceImplTest {

    @Mock
    private KorisnikRepository korisnikRepository;

    @InjectMocks
    private KorisnikServiceImpl korisnikService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Korisnik> korisnici = Arrays.asList(new Korisnik(), new Korisnik());
        when(korisnikRepository.findAll()).thenReturn(korisnici);

        List<Korisnik> result = korisnikService.findAll();

        assertEquals(korisnici, result);
        verify(korisnikRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Korisnik korisnik = new Korisnik();
        when(korisnikRepository.findById(id)).thenReturn(Optional.of(korisnik));

        Optional<Korisnik> result = korisnikService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(korisnik, result.get());
        verify(korisnikRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(korisnikRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Korisnik> result = korisnikService.findById(id);

        assertFalse(result.isPresent());
        verify(korisnikRepository, times(1)).findById(id);
    }

    @Test
    public void testCreate() {
        Korisnik korisnik = new Korisnik();
        when(korisnikRepository.save(korisnik)).thenReturn(korisnik);

        Korisnik result = korisnikService.create(korisnik);

        assertEquals(korisnik, result);
        verify(korisnikRepository, times(1)).save(korisnik);
    }

    @Test
    public void testUpdate() {
        Korisnik korisnik = new Korisnik();
        when(korisnikRepository.save(korisnik)).thenReturn(korisnik);

        Korisnik result = korisnikService.update(korisnik);

        assertEquals(korisnik, result);
        verify(korisnikRepository, times(1)).save(korisnik);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(korisnikRepository).deleteById(id);

        korisnikService.deleteById(id);

        verify(korisnikRepository, times(1)).deleteById(id);
    }



    @Test
    public void testLoginFailure() {
        String email = "test@example.com";
        String sifra = "password";
        when(korisnikRepository.findByEmailAndSifra(email, sifra)).thenReturn(Optional.empty());

        ResponseEntity<?> response = korisnikService.login(email, sifra);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Login failed", response.getBody());
        verify(korisnikRepository, times(1)).findByEmailAndSifra(email, sifra);
    }

    @Test
    public void testEmailExists() {
        String email = "test@example.com";
        when(korisnikRepository.findByEmail(email)).thenReturn(Optional.of(new Korisnik()));

        boolean exists = korisnikService.emailPostoji(email);

        assertTrue(exists);
        verify(korisnikRepository, times(1)).findByEmail(email);
    }

    @Test
    public void testEmailDoesNotExist() {
        String email = "test@example.com";
        when(korisnikRepository.findByEmail(email)).thenReturn(Optional.empty());

        boolean exists = korisnikService.emailPostoji(email);

        assertFalse(exists);
        verify(korisnikRepository, times(1)).findByEmail(email);
    }
}
