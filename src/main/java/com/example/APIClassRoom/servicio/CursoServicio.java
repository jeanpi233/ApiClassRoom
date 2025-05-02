package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.modelos.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.ICursoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    @Autowired
    ICursoRepositorio repositorio;

    // Guardar curso
    public Curso guardarCurso(Curso curso) {
        return this.repositorio.save(curso);
    }

    // Modificar curso
    public Curso modificarCurso(Integer id, Curso datosNuevos) {
        Optional<Curso> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId_curso(id); // Asegúrate que tu modelo tenga setId_curso()
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Curso con ID " + id + " no encontrado");
        }
    }

    // Buscar curso por ID
    public Curso buscarCursoPorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso con ID " + id + " no encontrado"));
    }

    // Buscar todos los cursos
    public List<Curso> buscarTodosCursos() {
        return this.repositorio.findAll();
    }

    // Eliminar curso
    public String eliminarCurso(Integer id) {
        Optional<Curso> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Curso eliminado correctamente";
        } else {
            throw new RuntimeException("Curso con ID " + id + " no encontrado");
        }
    }
}
