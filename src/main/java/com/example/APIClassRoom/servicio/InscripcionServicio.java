package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
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

    public Inscripcion guardarInscripcion(Inscripcion inscripcion) throws Exception {
        try {
            return this.repositorio.save(inscripcion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Inscripcion modificarInscripcion(Integer id, Inscripcion datosNuevos) throws Exception {
        try {
            Optional<Inscripcion> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Inscripcion buscarInscripcionPorId(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcion = this.repositorio.findById(id);
            if (inscripcion.isPresent()) {
                return inscripcion.get();
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Inscripcion> buscarTodasInscripciones() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarInscripcion(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcion = this.repositorio.findById(id);
            if (inscripcion.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
