package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_docente;

    @Column(name = "especialidad", unique = true, length = 100)
    private String especialidad;

    private TipoUsuario tipoUsuario;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference
    private Usuario usuario;

    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;

    public Docente() {
    }

    public Docente(Integer id_docente, String especialidad, TipoUsuario tipoUsuario) {
        this.id_docente = id_docente;
        this.especialidad = especialidad;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters and setters
    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
