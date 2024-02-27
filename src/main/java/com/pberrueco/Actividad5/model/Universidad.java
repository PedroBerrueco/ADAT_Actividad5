package com.pberrueco.Actividad5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "fav_universities")
public class Universidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String adress;
    private Integer ranking;

    @OneToMany(mappedBy = "universidad")
    private Set<Alumno> alumnos = new HashSet<>();
}
