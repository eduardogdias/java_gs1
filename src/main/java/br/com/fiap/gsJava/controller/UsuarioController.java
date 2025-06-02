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

import br.com.fiap.gsJava.dto.usuario.UsuarioDTO;
import br.com.fiap.gsJava.dto.usuario.UsuarioRequestDTO;
import br.com.fiap.gsJava.entity.Usuario;
import br.com.fiap.gsJava.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
		UsuarioDTO dto = usuarioService.findById(id);
		return ResponseEntity.ok().body(dto);				
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
		UsuarioDTO dto = usuarioService.save(usuarioRequestDTO);
		return ResponseEntity.created(null).body(dto);	
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
	    UsuarioDTO usuarioAtualizado = usuarioService.update(id, usuarioRequestDTO);
	    return ResponseEntity.ok().body(usuarioAtualizado);
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuario> deleteById(@PathVariable Long id){
		Usuario Usuario = usuarioService.deleteById(id);
		return ResponseEntity.ok().body(Usuario);			
	}
	
}
