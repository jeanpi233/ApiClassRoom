package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
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

    public Materia guardarMateria(Materia materia) throws Exception {
        try {
            return this.repositorio.save(materia);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Materia modificarMateria(Integer id, Materia datosNuevos) throws Exception {
        try {
            Optional<Materia> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Materia buscarMateriaPorId(Integer id) throws Exception {
        try {
            Optional<Materia> materia = this.repositorio.findById(id);
            if (materia.isPresent()) {
                return materia.get();
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Materia> buscarTodasMaterias() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarMateria(Integer id) throws Exception {
        try {
            Optional<Materia> materia = this.repositorio.findById(id);
            if (materia.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
