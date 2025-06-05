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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gsJava.dtos.local.LocalRequestDTO;
import br.com.fiap.gsJava.dtos.local.LocalResponseDTO;
import br.com.fiap.gsJava.services.LocalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {

	
	@Autowired
	private LocalService localService;
	
	@GetMapping
	public ResponseEntity<List<LocalResponseDTO>> findAll(@RequestParam(required = false) Boolean status){
		List<LocalResponseDTO> list;
		
		if(status == null) {
			list = localService.findAll();
		} else {
			list = localService.findByStatus(status);
		}
		
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LocalResponseDTO> findById(@PathVariable Long id){
		LocalResponseDTO local = localService.findById(id);
		return ResponseEntity.ok().body(local);			
		
	}
	
	@PostMapping
	public ResponseEntity<LocalResponseDTO> save(@RequestBody @Valid LocalRequestDTO localDTO){
		LocalResponseDTO result = localService.save(localDTO);
		return ResponseEntity.created(null).body(result);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LocalResponseDTO> update(@PathVariable Long id, @RequestBody @Valid LocalRequestDTO localDTO){
		LocalResponseDTO LocalAtualizado = localService.update(id, localDTO);
		return ResponseEntity.ok().body(LocalAtualizado);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<LocalResponseDTO> deleteById(@PathVariable Long id){
		LocalResponseDTO local = localService.deleteById(id);
		return ResponseEntity.ok().body(local);	
	}
	
}
