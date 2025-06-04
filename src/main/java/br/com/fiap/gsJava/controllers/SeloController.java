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

import br.com.fiap.gsJava.entities.Selo;
import br.com.fiap.gsJava.services.SeloService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/selos")
public class SeloController {

	
	@Autowired
	private SeloService seloService;
	
	@GetMapping
	public ResponseEntity<List<Selo>> findAll(){
		List<Selo> list = seloService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Selo> findById(@PathVariable Long id){
		Selo selo = seloService.findById(id);
		return ResponseEntity.ok().body(selo);			
		
	}
	
	@PostMapping
	public ResponseEntity<Selo> save(@RequestBody @Valid Selo selo){
		Selo result = seloService.save(selo);
		return ResponseEntity.created(null).body(result);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Selo> update(@PathVariable Long id, @RequestBody @Valid Selo selo){
		Selo seloAtualizado = seloService.update(id, selo);
		return ResponseEntity.ok().body(seloAtualizado);
		
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Selo> deleteById(@PathVariable Long id){
		Selo selo = seloService.deleteById(id);
		return ResponseEntity.ok().body(selo);	
		
		
	}
	
}
