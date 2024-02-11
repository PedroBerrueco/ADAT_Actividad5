package com.pberrueco.Actividad5.service;

import com.pberrueco.Actividad5.model.Universidad;
import com.pberrueco.Actividad5.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversidadService {
    @Autowired
    UniversidadRepository universidadRepository;

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


}
