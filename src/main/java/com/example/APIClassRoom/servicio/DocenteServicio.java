package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IDocenteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired // Inyección de dependencias
    IDocenteRepositorio repositorio;

    // GUARDAR
    public Docente guardarDocente(Docente datosDocente) throws Exception {
        try {
            return this.repositorio.save(datosDocente);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // MODIFICAR
    public Docente modificarDocente(Integer id, Docente datosDocente) throws Exception {
        try {
            Optional<Docente> docenteExistente = this.repositorio.findById(id);
            if (docenteExistente.isPresent()) {
                datosDocente.setId_docente(id); // Asegurar que se actualiza el correcto
                return this.repositorio.save(datosDocente);
            } else {
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCOTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR POR ID
    public Docente buscarDocentePorId(Integer id) throws Exception {
        try {
            Optional<Docente> docenteBuscado = this.repositorio.findById(id);
            if (docenteBuscado.isPresent()) {
                return docenteBuscado.get();
            } else {
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCOTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<Docente> buscarTodosDocentes() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // ELIMINAR
    public boolean eliminarDocente(Integer id) throws Exception {
        try {
            Optional<Docente> docenteBuscado = this.repositorio.findById(id);
            if (docenteBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCOTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
