package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_materia;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id")
    @JsonBackReference
    private Curso curso;

    @OneToMany(mappedBy = "materia")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    public Materia() {
    }

    public Materia(Integer id_materia, String nombre, Curso curso) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters and setters
    public Integer getId_materia() {
        return id_materia;
    }

    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
