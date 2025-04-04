package modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id_inscripcion;
    @Column (name = "fechaInscripcion")
    private Timestamp fechaInscripcion;


    @OneToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    @JsonManagedReference
    private Estudiante estudiante;


    @OneToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id")
    @JsonManagedReference
    private Curso curso;


    public Inscripcion() {
    }

    public Inscripcion(Timestamp fechaInscripcion, Integer id_inscripcion) {
        this.fechaInscripcion = fechaInscripcion;
        this.id_inscripcion = id_inscripcion;
    }

    public Integer getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Integer id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Timestamp getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Timestamp fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
