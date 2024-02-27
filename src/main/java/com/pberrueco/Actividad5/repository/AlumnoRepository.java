package com.pberrueco.Actividad5.repository;

import com.pberrueco.Actividad5.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
