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

    @Column(name = "direcion", nullable = false, length = 255 )
    private String direccion;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference(value = "estudiante-usuario")
    private Usuario usuario;

    public Estudiante() {
    }


    public Estudiante(Usuario usuario,Integer id, Integer grado, LocalDate fechaNacimiento, String direccion) {
        this.id = id;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.usuario = usuario;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}