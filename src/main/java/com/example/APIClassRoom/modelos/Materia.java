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
    @Column(name = "id_materia")
    private Integer id;

    @Column( nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;


    public Materia() {
    }

    public Materia(Integer id, String nombre, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

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
}
