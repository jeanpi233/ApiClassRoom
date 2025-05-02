package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_curso;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id")
    @JsonBackReference
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Materia> materias;

    public Curso() {
    }

    public Curso(Integer id_curso, String nombre, Docente docente) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.docente = docente;
    }

    // Getters and setters
    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
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
