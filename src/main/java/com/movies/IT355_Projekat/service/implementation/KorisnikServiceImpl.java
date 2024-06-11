package com.movies.IT355_Projekat.service.implementation;

import com.movies.IT355_Projekat.entity.Korisnik;
import com.movies.IT355_Projekat.repositorty.KorisnikRepository;
import com.movies.IT355_Projekat.security.tools.JwtTool;
import com.movies.IT355_Projekat.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;


    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Optional<Korisnik> findById(Integer korisnik_id) {
        return korisnikRepository.findById(korisnik_id);
    }

    @Override
    public Korisnik create(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik update(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public void deleteById(Integer korisnik_id) {
        korisnikRepository.deleteById(korisnik_id);

    }

   @Override
    public ResponseEntity<?> login(String email, String sifra) {
        try {
            Optional<Korisnik> optionalKorisnik = korisnikRepository.findByEmailAndSifra(email, sifra);
            if (optionalKorisnik.isEmpty()) {
                return new ResponseEntity<>("Login failed", HttpStatus.BAD_REQUEST);
            }
            Korisnik korisnik = optionalKorisnik.get();
            String jwt = JwtTool.generateToken(korisnik.getEmail());


            Map<String, Object> response = new HashMap<>();
            response.put("korisnik", korisnik);
            response.put("jwt", jwt);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public boolean emailPostoji(String email) {
        return korisnikRepository.findByEmail(email).isPresent();
    }

}
