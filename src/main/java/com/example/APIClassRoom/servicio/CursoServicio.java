package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
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

    public Curso guardarCurso(Curso curso) throws Exception {
        try {
            return this.repositorio.save(curso);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Curso modificarCurso(Integer id, Curso datosNuevos) throws Exception {
        try {
            Optional<Curso> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Curso buscarCursoPorId(Integer id) throws Exception {
        try {
            Optional<Curso> curso = this.repositorio.findById(id);
            if (curso.isPresent()) {
                return curso.get();
            } else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Curso> buscarTodosCursos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarCurso(Integer id) throws Exception {
        try {
            Optional<Curso> curso = this.repositorio.findById(id);
            if (curso.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
