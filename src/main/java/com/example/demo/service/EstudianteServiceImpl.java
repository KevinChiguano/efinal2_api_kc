package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTo;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}


	
	private EstudianteTo convertir(Estudiante estudiante) {
		
		EstudianteTo to = new EstudianteTo();
		to.setId(estudiante.getId());
		to.setApellido(estudiante.getApellido());
		to.setCedula(estudiante.getCedula());
		to.setNombre(estudiante.getNombre());
		
		return to;
		
	}



	@Override
	public EstudianteTo buscarPorId(String cedula) {
		// TODO Auto-generated method stub
		return this.convertir(this.estudianteRepository.buscarPorId(cedula));
	}

}
