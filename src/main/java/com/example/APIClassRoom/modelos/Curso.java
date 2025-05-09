package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference(value = "docente-curso")
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Materia> materias;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    public Curso() {
    }

    public Curso(Integer id, String nombre, Docente docente) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
