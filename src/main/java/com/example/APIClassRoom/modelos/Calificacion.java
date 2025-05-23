package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer id;

    @Column(nullable = false)
    private BigDecimal nota;

    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    @JsonBackReference(value = "materia-calificaciones")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonBackReference(value = "estudiante-calificaciones")
    private Estudiante estudiante;

    public Calificacion() {
    }

    public Calificacion(Integer id, BigDecimal nota, LocalDate fechaEvaluacion, Estudiante estudiante,Materia materia) {
        this.id = id;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}