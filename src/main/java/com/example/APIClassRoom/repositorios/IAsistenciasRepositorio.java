package com.example.APIClassRoom.repositorios;

import com.example.APIClassRoom.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciasRepositorio extends JpaRepository<Asistencia, Integer> {
}
