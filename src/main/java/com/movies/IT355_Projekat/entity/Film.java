package com.movies.IT355_Projekat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "ime", nullable = false)
    private String ime;

    @Lob
    @Column(name = "zanar", nullable = false)
    private String zanar;

    @Column(name = "godina_objavljivanja", nullable = false)
    private Integer godinaObjavljivanja;

    @Column(name = "trajanje", nullable = false)
    private Integer trajanje;

    @Lob
    @Column(name = "slika", nullable = false)
    private String slika;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "direktor_id", nullable = false)
    private Direktor direktor;

    @ManyToMany
    @JoinTable(
            name = "glumac_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "glumac_id")
    )
    private Set<Glumac> glumci = new LinkedHashSet<>();


}