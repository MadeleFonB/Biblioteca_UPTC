package com.agenda.biblioteca_uptc.controller;

import com.agenda.biblioteca_uptc.model.Prestamo;
import com.agenda.biblioteca_uptc.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoService.getAllPrestamos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id) {
        return prestamoService.getPrestamoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPrestamo(@Valid @RequestBody Prestamo prestamo) {
        // Aquí puedes agregar validaciones específicas, p.ej fechas
        if (prestamo.getFechaDevolucionEsperada().isBefore(prestamo.getFechaPrestamo())) {
            return ResponseEntity.badRequest().body("La fecha de devolución esperada no puede ser anterior a la fecha de préstamo");
        }
        Prestamo creado = prestamoService.savePrestamo(prestamo);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrestamo(@PathVariable Long id, @Valid @RequestBody Prestamo prestamoDetails) {
        return prestamoService.getPrestamoById(id).map(prestamo -> {
            if (prestamoDetails.getFechaDevolucionEsperada().isBefore(prestamoDetails.getFechaPrestamo())) {
                return ResponseEntity.badRequest().body("La fecha de devolución esperada no puede ser anterior a la fecha de préstamo");
            }
            prestamo.setUsuario(prestamoDetails.getUsuario());
            prestamo.setLibro(prestamoDetails.getLibro());
            prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
            prestamo.setFechaDevolucionEsperada(prestamoDetails.getFechaDevolucionEsperada());
            prestamo.setFechaDevolucionReal(prestamoDetails.getFechaDevolucionReal());
            Prestamo updated = prestamoService.savePrestamo(prestamo);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        if (prestamoService.getPrestamoById(id).isPresent()) {
            prestamoService.deletePrestamo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/atrasados")
    public List<Prestamo> getPrestamosAtrasados() {
        return prestamoService.getPrestamosAtrasados();
    }
}
