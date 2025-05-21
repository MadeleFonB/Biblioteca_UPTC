package com.agenda.biblioteca_uptc.service;

import com.agenda.biblioteca_uptc.model.Prestamo;
import com.agenda.biblioteca_uptc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Optional<Prestamo> getPrestamoById(Long id) {
        return prestamoRepository.findById(id);
    }

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public List<Prestamo> getPrestamosAtrasados() {
        LocalDate hoy = LocalDate.now();
        return prestamoRepository.findByFechaDevolucionRealIsNullAndFechaDevolucionEsperadaBefore(hoy);
    }

    public void deletePrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}
