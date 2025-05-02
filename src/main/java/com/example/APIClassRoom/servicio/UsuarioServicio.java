package com.example.APIClassRoom.servicio;

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

    // Guardar usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return this.repositorio.save(usuario);
    }

    // Modificar usuario
    public Usuario modificarUsuario(Integer id, Usuario datosNuevos) { // Usando Integer
        Optional<Usuario> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId_usuario(id);  // Asegúrate de que el setter sea correcto
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(Integer id) {  // Usando Integer
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

    // Buscar todos los usuarios
    public List<Usuario> buscarTodosUsuarios() {
        return this.repositorio.findAll();
    }

    // Eliminar usuario
    public String eliminarUsuario(Integer id) {  // Usando Integer
        Optional<Usuario> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Usuario eliminado correctamente";
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
    }
}
