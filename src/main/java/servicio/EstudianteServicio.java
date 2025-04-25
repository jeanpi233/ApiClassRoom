package servicio;

import modelos.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IEstudianteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return this.repositorio.save(estudiante);
    }

    public Estudiante modificarEstudiante(Integer id, Estudiante datosNuevos) {
        Optional<Estudiante> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            datosNuevos.setId_estudiante(id);
            return this.repositorio.save(datosNuevos);
        } else {
            throw new RuntimeException("Estudiante con ID " + id + " no encontrado");
        }
    }

    public Estudiante buscarEstudiantePorId(Integer id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante con ID " + id + " no encontrado"));
    }

    public List<Estudiante> buscarTodosEstudiantes() {
        return this.repositorio.findAll();
    }

    public String eliminarEstudiante(Integer id) {
        Optional<Estudiante> encontrado = this.repositorio.findById(id);
        if (encontrado.isPresent()) {
            this.repositorio.deleteById(id);
            return "Estudiante eliminado correctamente";
        } else {
            throw new RuntimeException("Estudiante con ID " + id + " no encontrado");
        }
    }
}
