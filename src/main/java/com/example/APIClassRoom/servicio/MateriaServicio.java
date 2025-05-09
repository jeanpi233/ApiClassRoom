package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.modelos.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IMateriaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicio {

    @Autowired
    IMateriaRepositorio repositorio;

    // Guardar materia
    public Materia guardarMateria(Materia materia) {
        return this.repositorio.save(materia);
    }

    // Modificar materia
    public Materia modificarMateria(Integer id, Materia datosNuevos) {
        Optional<Materia> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId(id); // Asegúrate que tu modelo tenga setId()
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Materia con ID " + id + " no encontrada");
        }
    }

    // Buscar materia por ID
    public Materia buscarMateriaPorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia con ID " + id + " no encontrada"));
    }

    // Buscar todas las materias
    public List<Materia> buscarTodasMaterias() {
        return this.repositorio.findAll();
    }

    // Eliminar materia
    public String eliminarMateria(Integer id) {
        Optional<Materia> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Materia eliminada correctamente";
        } else {
            throw new RuntimeException("Materia con ID " + id + " no encontrada");
        }
    }
}
