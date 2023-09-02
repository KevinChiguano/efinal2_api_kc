package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTo;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);

	public EstudianteTo buscarPorId(String cedula);

}
