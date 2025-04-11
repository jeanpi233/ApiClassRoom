package servicio;

import ayudas.MensajesAPI;
import modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IDocenteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {
    @Autowired //Inyeccion de dependencias
    IDocenteRepositorio repositorio;

    //En el servicio implementamos los metodos
    //que necesitamos segun los servicios a ofrecer

    //GUARDAR
    public Docente guardarDocente(Docente datosDocente) throws Exception {
        try {
            return this.repositorio.save(datosDocente);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    //MODIFICAR

    //BUSCAR POR ID

    //BUSCAR TODOS
    public List<Docente> buscarTodosDocentes() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }


    //ELIMINAR
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
