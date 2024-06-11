package com.movies.IT355_Projekat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "glumac")
public class Glumac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "glumac_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "ime", nullable = false)
    private String ime;

    @Lob
    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Lob
    @Column(name = "biografija", nullable = false)
    private String biografija;


}