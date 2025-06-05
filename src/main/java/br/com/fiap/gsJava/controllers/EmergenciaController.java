package br.com.fiap.gsJava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gsJava.dtos.emergencia.EmergenciaRequestDTO;
import br.com.fiap.gsJava.dtos.emergencia.EmergenciaRequestPutDTO;
import br.com.fiap.gsJava.dtos.emergencia.EmergenciaResponseDTO;
import br.com.fiap.gsJava.services.EmergenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/emergencias")
public class EmergenciaController {

	
	@Autowired
	private EmergenciaService emergenciaService;
	
	@GetMapping
	public ResponseEntity<List<EmergenciaResponseDTO>> findAll(){
		List<EmergenciaResponseDTO> list = emergenciaService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmergenciaResponseDTO> findById(@PathVariable Long id){
		EmergenciaResponseDTO emergencia = emergenciaService.findById(id);
		return ResponseEntity.ok().body(emergencia);			
		
	}
	
	@PostMapping
	public ResponseEntity<EmergenciaResponseDTO> save(@RequestBody @Valid EmergenciaRequestDTO emergenciaDTO){
		EmergenciaResponseDTO result = emergenciaService.save(emergenciaDTO);
		return ResponseEntity.created(null).body(result);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmergenciaResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EmergenciaRequestPutDTO emergenciaDTO){
		EmergenciaResponseDTO EmergenciaAtualizado = emergenciaService.update(id, emergenciaDTO);
		return ResponseEntity.ok().body(EmergenciaAtualizado);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmergenciaResponseDTO> deleteById(@PathVariable Long id){
		EmergenciaResponseDTO emergencia = emergenciaService.deleteById(id);
		return ResponseEntity.ok().body(emergencia);	
	}
	
}
