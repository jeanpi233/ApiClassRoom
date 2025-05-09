package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.modelos.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IAsistenciasRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    IAsistenciasRepositorio repositorio;

    // Guardar una nueva asistencia
    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return this.repositorio.save(asistencia);
    }

    // Modificar una asistencia existente
    public Asistencia modificarAsistencia(Integer id, Asistencia datosNuevos) {
        Optional<Asistencia> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId(id); // Asegúrate de tener un setter para el ID en el modelo
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Asistencia con ID " + id + " no encontrada");
        }
    }

    // Buscar asistencia por ID
    public Asistencia buscarAsistenciaPorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia con ID " + id + " no encontrada"));
    }

    // Buscar todas las asistencias
    public List<Asistencia> buscarTodasAsistencias() {
        return this.repositorio.findAll();
    }

    // Eliminar una asistencia por ID
    public String eliminarAsistencia(Integer id) {
        Optional<Asistencia> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Asistencia eliminada correctamente";
        } else {
            throw new RuntimeException("Asistencia con ID " + id + " no encontrada");
        }
    }
}
