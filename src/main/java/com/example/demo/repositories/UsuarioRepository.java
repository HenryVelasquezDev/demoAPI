package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModel> findByNombreOrApellido(String nombre, String apellido);
}
