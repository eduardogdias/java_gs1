package br.com.fiap.gsJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import br.com.fiap.gsJava.dto.publicacao.PublicacaoRequestDTO;
import br.com.fiap.gsJava.dto.publicacao.PublicacaoRequestPutDTO;
import br.com.fiap.gsJava.dto.publicacao.PublicacaoResponseDTO;
import br.com.fiap.gsJava.service.PublicacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/publicacoes")
public class PublicacaoController {

	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@GetMapping
	public ResponseEntity<List<PublicacaoResponseDTO>> findAll(@RequestParam(required = false) Boolean status) {
		List<PublicacaoResponseDTO> listDto;
		if (status == null) {
			listDto = publicacaoService.findAll(); // retorna todas as publis
	    } else {
	    	listDto = publicacaoService.findAllByStatus(status); // retorna filtradas por status (ativas ou inativas)
	    }

	    return ResponseEntity.ok().body(listDto);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PublicacaoResponseDTO> findById(@PathVariable Long id){
		PublicacaoResponseDTO dto = publicacaoService.findById(id);
		return ResponseEntity.ok().body(dto);			
		
	}

	
	@PostMapping
	public ResponseEntity<PublicacaoResponseDTO> save(@RequestBody @Valid PublicacaoRequestDTO publicacaoRequestDTO){
		PublicacaoResponseDTO dto = publicacaoService.save(publicacaoRequestDTO);
		return ResponseEntity.created(null).body(dto);	
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<PublicacaoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PublicacaoRequestPutDTO publicacaoRequestPutDTO){
		PublicacaoResponseDTO dto = publicacaoService.update(id, publicacaoRequestPutDTO);
		return ResponseEntity.ok().body(dto);	
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PublicacaoResponseDTO> deleteById(@PathVariable Long id){
		PublicacaoResponseDTO dto = publicacaoService.deleteById(id);
		return ResponseEntity.ok().body(dto);		
	}
	
}
