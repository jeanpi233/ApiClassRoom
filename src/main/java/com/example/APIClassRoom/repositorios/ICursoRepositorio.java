package com.example.APIClassRoom.repositorios;

import com.example.APIClassRoom.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso, Integer> {
}
