package modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_calificacion;
    @Column (name = "nota",nullable = false,length = 10)
    private Double nota;
    @Column (name = "fechaEvaluacion", nullable = false, length = 90)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id")
    @JsonManagedReference
    private Materia materia;



    public Calificacion() {
    }

    public Calificacion(Integer id_calificacion, Double nota, LocalDate fechaEvaluacion, Estudiante estudiante) {
        this.id_calificacion = id_calificacion;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Integer id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
