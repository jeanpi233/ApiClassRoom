package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.modelos.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IInscripcionRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicio {

    @Autowired
    IInscripcionRepositorio repositorio;

    // Guardar inscripción
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        return this.repositorio.save(inscripcion);
    }

    // Modificar inscripción
    public Inscripcion modificarInscripcion(Integer id, Inscripcion datosNuevos) {
        Optional<Inscripcion> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId_inscripcion(id); // Asegúrate que tu modelo tenga setId_inscripcion()
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Inscripción con ID " + id + " no encontrada");
        }
    }

    // Buscar inscripción por ID
    public Inscripcion buscarInscripcionPorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción con ID " + id + " no encontrada"));
    }

    // Buscar todas las inscripciones
    public List<Inscripcion> buscarTodasInscripciones() {
        return this.repositorio.findAll();
    }

    // Eliminar inscripción
    public String eliminarInscripcion(Integer id) {
        Optional<Inscripcion> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Inscripción eliminada correctamente";
        } else {
            throw new RuntimeException("Inscripción con ID " + id + " no encontrada");
        }
    }
}
