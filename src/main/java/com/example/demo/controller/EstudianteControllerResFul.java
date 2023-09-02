package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTo;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerResFul {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/{cedula}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTo> buscarPorId(@PathVariable String cedula) {
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add("detalle", "Operacion exitosa");
		
		
		return new ResponseEntity<>(this.estudianteService.buscarPorId(cedula), cabecera, HttpStatus.OK);
	}
	
	

}
