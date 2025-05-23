package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
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

    public Asistencia guardarAsistencia(Asistencia asistencia) throws Exception {
        try {
            return this.repositorio.save(asistencia);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Asistencia modificarAsistencia(Integer id, Asistencia datosNuevos) throws Exception {
        try {
            Optional<Asistencia> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Asistencia buscarAsistenciaPorId(Integer id) throws Exception {
        try {
            Optional<Asistencia> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                return encontrado.get();
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Asistencia> buscarTodasAsistencias() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarAsistencia(Integer id) throws Exception {
        try {
            Optional<Asistencia> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
