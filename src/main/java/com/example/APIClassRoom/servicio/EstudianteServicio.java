package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IEstudianteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstudiante(Estudiante estudiante) throws Exception {
        try {
            return this.repositorio.save(estudiante);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Estudiante modificarEstudiante(Integer id, Estudiante datosNuevos) throws Exception {
        try {
            Optional<Estudiante> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.ESTUDINATE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Estudiante buscarEstudiantePorId(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudiante = this.repositorio.findById(id);
            if (estudiante.isPresent()) {
                return estudiante.get();
            } else {
                throw new Exception(MensajesAPI.ESTUDINATE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Estudiante> buscarTodosEstudiantes() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarEstudiante(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudiante = this.repositorio.findById(id);
            if (estudiante.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.ESTUDINATE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
