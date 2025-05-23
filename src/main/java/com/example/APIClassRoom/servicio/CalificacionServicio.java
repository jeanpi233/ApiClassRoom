package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
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

    public Calificacion guardarCalificacion(Calificacion calificacion) throws Exception {
        try {
            return this.repositorio.save(calificacion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Calificacion modificarCalificacion(Integer id, Calificacion datosNuevos) throws Exception {
        try {
            Optional<Calificacion> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Calificacion buscarCalificacionPorId(Integer id) throws Exception {
        try {
            Optional<Calificacion> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                return encontrado.get();
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Calificacion> buscarTodasCalificaciones() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarCalificacion(Integer id) throws Exception {
        try {
            Optional<Calificacion> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
