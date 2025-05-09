package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer id;

    @Column(name = "grado", nullable = false)
    private Integer grado;

    @Column(name = "fecha_Nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 250)
    private String diccionario;


    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia> asistencias;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference(value = "estudiante-usuario")
    private Usuario usuario;

    public Estudiante() {
    }

    public Estudiante(Integer id, Integer grado, LocalDate fechaNacimiento, String diccionario) {
        this.id = id;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.diccionario = diccionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(String diccionario) {
        this.diccionario = diccionario;
    }
}