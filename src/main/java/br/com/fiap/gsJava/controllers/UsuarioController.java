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

import br.com.fiap.gsJava.dto.UsuarioDTO;
import br.com.fiap.gsJava.entities.Usuario;
import br.com.fiap.gsJava.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioService UsuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> list = UsuarioService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
		UsuarioDTO dto = UsuarioService.findById(id);
		return ResponseEntity.ok().body(dto);				
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario Usuario){
		Usuario result = UsuarioService.save(Usuario);
		return ResponseEntity.created(null).body(result);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario Usuario){
		Usuario UsuarioAtualizado = UsuarioService.update(id, Usuario);
		return ResponseEntity.ok().body(UsuarioAtualizado);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuario> deleteById(@PathVariable Long id){
		Usuario Usuario = UsuarioService.deleteById(id);
		return ResponseEntity.ok().body(Usuario);			
	}
	
}
