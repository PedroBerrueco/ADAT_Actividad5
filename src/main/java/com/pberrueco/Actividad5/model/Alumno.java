package com.pberrueco.Actividad5.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private Integer notamedia;

    @ManyToOne
    @JoinColumn(name = "universidad_id") //Como esperamos solo una universidad no hacemos Set
    private Universidad universidad;
}
