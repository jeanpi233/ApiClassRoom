package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante",nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Asistencia() {
    }


    public Asistencia(Integer id, LocalDate fecha, Estado estado, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

