package com.agenda.biblioteca_uptc.repository;

import com.agenda.biblioteca_uptc.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByFechaDevolucionRealIsNullAndFechaDevolucionEsperadaBefore(LocalDate fecha);

}
