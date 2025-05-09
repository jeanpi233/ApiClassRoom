package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.modelos.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.ICalificacionRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServicio {

    @Autowired
    ICalificacionRepositorio repositorio;

    // Guardar calificación
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return this.repositorio.save(calificacion);
    }

    // Modificar calificación
    public Calificacion modificarCalificacion(Integer id, Calificacion datosNuevos) {
        Optional<Calificacion> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId(id); // Asegúrate de tener este setter en tu modelo
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Calificación con ID " + id + " no encontrada");
        }
    }

    // Buscar calificación por id
    public Calificacion buscarCalificacionPorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación con ID " + id + " no encontrada"));
    }

    // Buscar todas las calificaciones
    public List<Calificacion> buscarTodasCalificaciones() {
        return this.repositorio.findAll();
    }

    // Eliminar calificación
    public String eliminarCalificacion(Integer id) {
        Optional<Calificacion> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Calificación eliminada correctamente";
        } else {
            throw new RuntimeException("Calificación con ID " + id + " no encontrada");
        }
    }
}
