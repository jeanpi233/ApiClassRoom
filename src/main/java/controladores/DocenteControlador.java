package controladores;

import modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.DocenteServicio;

@RestController
@RequestMapping("/docentes")
public class DocenteControlador {
    @Autowired
    DocenteServicio servicio;
    //controlador para guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Docente datosEnvidosPorElCliente){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarDocente(datosEnvidosPorElCliente));
        }catch(Exception errorAPI){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
    //controlardor para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Docente datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarDocente(id,datos));//error flata crea modificar datos docente
        }catch(Exception errorAPI){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
    //controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id ){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarDocentePorId(id)); // falta hacer buscar docente por id en servicios Docente
        }catch(Exception errorAPI){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
    //controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosDocentes());
        }catch(Exception errorAPI){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
    //controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarDocente(id));
        }catch(Exception errorAPI){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
}
