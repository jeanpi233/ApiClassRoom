package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_estudiante;

    @Column(name = "grado", unique = true, length = 100)
    private String grado;

    @Column(name = "fechaNacimiento", unique = true, length = 100)
    private String fechaNacimiento;

    @Column(name = "diccionario", unique = true, length = 100)
    private String diccionario;

    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia> asistencias;

    public Estudiante() {
    }

    public Estudiante(Integer id_estudiante, String grado, String fechaNacimiento, String diccionario, TipoUsuario tipoUsuario) {
        this.id_estudiante = id_estudiante;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.diccionario = diccionario;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters and setters
    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(String diccionario) {
        this.diccionario = diccionario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
