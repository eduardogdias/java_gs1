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

import br.com.fiap.gsJava.dtos.local.LocalDTO;
import br.com.fiap.gsJava.services.LocalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {

	
	@Autowired
	private LocalService localService;
	
	@GetMapping
	public ResponseEntity<List<LocalDTO>> findAll(){
		List<LocalDTO> list = localService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LocalDTO> findById(@PathVariable Long id){
		LocalDTO local = localService.findById(id);
		return ResponseEntity.ok().body(local);			
		
	}
	
	@PostMapping
	public ResponseEntity<LocalDTO> save(@RequestBody @Valid LocalDTO localDTO){
		LocalDTO result = localService.save(localDTO);
		return ResponseEntity.created(null).body(result);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LocalDTO> update(@PathVariable Long id, @RequestBody @Valid LocalDTO localDTO){
		LocalDTO LocalAtualizado = localService.update(id, localDTO);
		return ResponseEntity.ok().body(LocalAtualizado);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<LocalDTO> deleteById(@PathVariable Long id){
		LocalDTO local = localService.deleteById(id);
		return ResponseEntity.ok().body(local);	
	}
	
}
