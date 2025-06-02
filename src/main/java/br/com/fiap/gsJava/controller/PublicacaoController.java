package br.com.fiap.gsJava.controller;

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

import br.com.fiap.gsJava.entity.Publicacao;
import br.com.fiap.gsJava.service.PublicacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/publicacoes")
public class PublicacaoController {

	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@GetMapping
	public ResponseEntity<List<Publicacao>> findAll(){
		List<Publicacao> list = publicacaoService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacao> findById(@PathVariable Long id){
		Publicacao Publicacao = publicacaoService.findById(id);
		return ResponseEntity.ok().body(Publicacao);			
		
	}
	
	@PostMapping
	public ResponseEntity<Publicacao> save(@RequestBody @Valid Publicacao Publicacao){
		Publicacao result = publicacaoService.save(Publicacao);
		return ResponseEntity.created(null).body(result);	
	}
	
	/*
	@PutMapping(value = "/{id}")
	public ResponseEntity<Publicacao> update(@PathVariable Long id, @RequestBody @Valid Publicacao Publicacao){
		Publicacao PublicacaoAtualizado = publicacaoService.update(id, Publicacao);
		return ResponseEntity.ok().body(PublicacaoAtualizado);
		
	}
*/
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Publicacao> deleteById(@PathVariable Long id){
		Publicacao Publicacao = publicacaoService.deleteById(id);
		return ResponseEntity.ok().body(Publicacao);	
		
		
	}
	
}
