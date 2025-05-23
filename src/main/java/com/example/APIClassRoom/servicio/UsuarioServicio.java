package com.example.APIClassRoom.servicio;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.APIClassRoom.repositorios.IUsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        try {
            return this.repositorio.save(usuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario modificarUsuario(Integer id, Usuario datosNuevos) throws Exception {
        try {
            Optional<Usuario> encontrado = this.repositorio.findById(id);
            if (encontrado.isPresent()) {
                datosNuevos.setId(id);
                return this.repositorio.save(datosNuevos);
            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuario = this.repositorio.findById(id);
            if (usuario.isPresent()) {
                return usuario.get();
            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Usuario> buscarTodosUsuarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarUsuario(Integer id) throws Exception {
        try {
            Optional<Usuario> usuario = this.repositorio.findById(id);
            if (usuario.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
