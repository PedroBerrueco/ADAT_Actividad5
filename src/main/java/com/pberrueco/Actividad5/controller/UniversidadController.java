package com.pberrueco.Actividad5.controller;

import com.pberrueco.Actividad5.model.Universidad;
import com.pberrueco.Actividad5.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/universities")
public class UniversidadController {

    private final UniversidadService universidadService;
    @Autowired
    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }
    @PostMapping
    public ResponseEntity<Universidad> save(@RequestBody Universidad universidad){
        Universidad universityNew = universidadService.saveOrUpdate(universidad);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(universityNew);
    }
    @GetMapping
    public ResponseEntity<List<Universidad>> getAllUniversities() {
        List<Universidad> universities = universidadService.getUniversities();
        return ResponseEntity.status(HttpStatus.OK).body(universities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Universidad>> getById(@PathVariable Long id) {
        Optional<Universidad> universidad = universidadService.getUniversity(id);
        if(universidad.isPresent()){
            return ResponseEntity.ok(universidad);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Universidad>> searchUniversities(@RequestParam String name) {
        List<Universidad> universidades = universidadService.searchByName(name);
        return ResponseEntity.ok(universidades);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Universidad>> delete(@PathVariable Long id) {
        universidadService.deleteUniversity(id);
        return ResponseEntity.ok().build();
    }

}
