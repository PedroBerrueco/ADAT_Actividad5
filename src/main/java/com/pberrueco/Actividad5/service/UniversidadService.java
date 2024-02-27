package com.pberrueco.Actividad5.service;

import com.pberrueco.Actividad5.dto.RequestAddOneDTO;
import com.pberrueco.Actividad5.model.Alumno;
import com.pberrueco.Actividad5.model.Universidad;
import com.pberrueco.Actividad5.repository.AlumnoRepository;
import com.pberrueco.Actividad5.repository.UniversidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UniversidadService {

    @Autowired
    private final AlumnoRepository alumnoRepository;
    private final UniversidadRepository universidadRepository;


    public UniversidadService(AlumnoRepository alumnoRepository, UniversidadRepository universidadRepository) {
        this.alumnoRepository = alumnoRepository;
        this.universidadRepository = universidadRepository;
    }

    public List<Universidad> getUniversities() { return universidadRepository.findAll(); }
    public Optional<Universidad> getUniversity(Long id){
        return universidadRepository.findById(id);
    }
    public Universidad saveOrUpdate(Universidad universidad){
        return universidadRepository.save(universidad);
    }
    public void deleteUniversity(Long id){ universidadRepository.deleteById(id);
    }
    public List<Universidad> searchByName(String name){ return universidadRepository.findByNameContainingIgnoreCase(name);}


    @Transactional
    public Alumno addOne(RequestAddOneDTO alumnoDTO) {
        //Crear alumno nuevo
        Alumno alumno = new Alumno();
        alumno.setName(alumnoDTO.getName());
        alumno.setSurname(alumnoDTO.getSurname());
        alumno.setNotamedia(alumnoDTO.getNotamedia());

        //BUscamos la uni por id y lo añadimos
        Universidad universidad = universidadRepository.findById(alumnoDTO.getUniversidad()).orElseThrow (() -> new RuntimeException("Universidad no encontrado"));
        alumno.setUniversidad(universidad);

        //Guardamos el alumno en la BD
       return alumnoRepository.save(alumno);
    }
}
