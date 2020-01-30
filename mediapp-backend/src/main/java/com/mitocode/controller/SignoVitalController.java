package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.SignoVital;
import com.mitocode.service.ISignoVitalService;

@RestController
@RequestMapping("/signosvitales")
public class SignoVitalController {
	
	@Autowired
	private ISignoVitalService service;
	
	@GetMapping
	public ResponseEntity<List<SignoVital>> listar(){
		 List<SignoVital> lista = service.listar();
		return new ResponseEntity<List<SignoVital>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SignoVital> listarPorId(@PathVariable("id") Integer id){
		SignoVital obj = service.leerPorId(id);
		if(obj.getIdSignosVitales() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<SignoVital>(obj, HttpStatus.OK); 
	}
	
	@PutMapping
	public ResponseEntity<SignoVital> modificar(@Valid @RequestBody SignoVital signoVital) {
		SignoVital obj = service.modificar(signoVital);
		return new ResponseEntity<SignoVital>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		SignoVital obj = service.leerPorId(id);
		if(obj.getIdSignosVitales() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody SignoVital signoVital) {
		SignoVital obj = service.registrar(signoVital);
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(signoVital.getIdSignosVitales()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
}
