package com.example.APIClassRoom.repositorios;

import com.example.APIClassRoom.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepositorio extends JpaRepository <Materia, Integer> {
}
