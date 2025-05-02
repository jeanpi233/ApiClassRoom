package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer id_asistencia;

    @Column(name = "fecha", nullable = false, length = 100)
    private LocalDate fecha;

    @Column(name = "estado", nullable = false, length = 100)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    @JsonManagedReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id")
    @JsonManagedReference
    private Curso curso;

    public Asistencia() {
    }

    public Asistencia(Integer id_asistencia, LocalDate fecha, Estado estado) {
        this.id_asistencia = id_asistencia;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters and setters
    public Integer getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Integer id_asistencia) {
        this.id_asistencia = id_asistencia;
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
}
