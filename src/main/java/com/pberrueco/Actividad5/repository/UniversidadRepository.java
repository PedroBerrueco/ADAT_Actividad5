package com.pberrueco.Actividad5.repository;

import com.pberrueco.Actividad5.model.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {

    List<Universidad> findByNameContainingIgnoreCase(String name);

}
