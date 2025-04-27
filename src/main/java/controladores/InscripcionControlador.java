package controladores;

import modelos.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.InscripcionServicio;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionControlador {

    @Autowired
    InscripcionServicio servicio;

    // Guardar inscripción
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Inscripcion datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarInscripcion(datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Modificar inscripción
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Inscripcion datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarInscripcion(id, datos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Buscar inscripción por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarInscripcionPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }

    // Buscar todas las inscripciones
    @GetMapping
    public ResponseEntity<?> buscarTodo() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodasInscripciones());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Eliminar inscripción
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarInscripcion(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }
}
