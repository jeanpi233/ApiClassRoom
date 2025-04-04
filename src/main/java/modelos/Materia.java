package modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "materia")
public class Materia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_materia")
    private Integer id_materia;
    @Column (name = "nombre",nullable = false,length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference
    private Usuario usuario;

    @OneToMany(mappedBy = "materia")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    public Materia() {
    }

    public Materia(Integer id_materia, String nombre) {
        this.id_materia = id_materia;
        this.nombre = nombre;
    }

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
}
